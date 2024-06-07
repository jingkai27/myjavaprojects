require 'json'
require 'httparty'

class KeepTrackOfToDo
    include HTTParty
    base_uri 'http://localhost:3000'  # This is the base URI for the API
    attr_accessor :todo
    # Task Class; a single instance of a Task object represents a single to-do object 
    class Task
        attr_accessor :id, :name, :completed
        def initialize(taskname)
            @id = generate_id
            @name = taskname
            @completed = "Not Completed"
        end

        def done
            @completed = "Completed"
        end

        # This function converts the object from a Task Class into a dictionary
        # This is largely for printing purposes.
        def to_h
            { id:@id, name: @name, completed: @completed }
        end

        def generate_id
            rand(1000..9999)
        end

        # This function converts the object from a dictionary into Task class object
        def self.from_h(hash)
            task = new(hash[:name])
            task.id = hash[:id]
            task.setCompleted(hash[:completed])
            task
          end

        def setName(taskname)
            @name = taskname
        end

        def setCompleted(done)
            if done == true
                @completed = "Completed"
            else
                @completed = "Not Completed"
            end
        end
    end

    def initialize
        @todo = []
    end

    # Function to add a single to-do item.
    def add(item)
        new_item = Task.new(item)
        response = self.class.post('/todos', body: new_item.to_h.to_json, headers: { 'Content-Type' => 'application/json' })
        if response.code==201
            puts "Task added successfully: #{item}"
        else
            puts "Task not added. Please try again. #{response.body}"
        end
        @todo << new_item
        puts "New Task added: #{item}"
    end

    # Function to edit a single to-do item.
    def edit
        prompt = "Which item do you want to edit?"
        list
        p prompt
        num = gets.chomp
        if num.match?(/^\d+$/)
            num = num.to_i - 1
        else
            puts "Invalid input. Please enter a valid number."
        end

        if num < todo.length() and num >= 0
            task = todo[num]
            puts "What do you want to edit?\n1. Task\n2. Status"
            choice = gets.chomp.to_i

            case choice 
            when 1
                print "Enter name of new task: "
                new_task = gets.chomp
                task.setName(new_task)
            when 2
                print "Completed? Enter Y/N --->"
                completed = gets.chomp.upcase
                if completed == "Y"
                    task.setCompleted(true)
                    puts "#{task.name}: Completed"
                elsif completed == "N"
                    task.setCompleted(false)
                    puts "#{task.name}: Not Completed"
                else
                    puts "Invalid Input"
                end
            else
                puts " Invalid Input"
            end
            
            response = self.class.put("/todos/#{task.id}", body: task.to_h.to_json, headers: { 'Content-Type' => 'application/json' })
            if response.code == 200
                puts "Task updated: #{task.name}"
            else
                puts "Failed to update task: #{response.body}"
            end
        else
            return "Please select a valid number." 
        end 
    end

    # Function to mark a single to-do item as complete.
    def complete
        prompt = "Which item do you want to mark completed?"
        list
        p prompt
        num = gets.chomp.to_i - 1
        if num < todo.length() and num >= 0
            task = todo[num]
            task.setCompleted(true)
            response = self.class.put("/todos/#{task.id}", body: task.to_h.to_json, headers: { 'Content-Type' => 'application/json' })
            if response.code == 200
                puts "Task marked as completed: #{task.name}"
            else
                puts "Failed to mark task as completed: #{response.body}"
            end
        else
            return "Please select a valid number." 
        end 
    end

    # Function to delete a single to-do item.
    def delete
        prompt = "Which item do you want to delete?"
        list
        p prompt
        num = gets.chomp.to_i - 1
        if num < todo.length() and num >= 0
            task = @todo[num]
            response = self.class.delete("/todos/#{task.id}")
            if response.code == 204
                @todo.delete_at(num)
                puts "Task deleted: #{task.name}"
            else
                puts "Failed to delete task: #{response.body}"
            end
        else
            return "Number entered is not a valid number"
        end
    end

    def fetch_todos
        response = self.class.get('/todos')
        if response.code == 200
            @todo = response.parsed_response.map { |task_hash| Task.from_h(task_hash.transform_keys(&:to_sym)) }
        else
            puts "Failed to fetch tasks: #{response.body}"
        end
    end

    def list 
        fetch_todos
        puts "Your To-Do List: "
        @todo.each_with_index do |task, index|
            puts "#{index+1}. #{task.name}; Status: #{task.completed}"
        end
        @todo
    end

    # Function to save the to-do list to a file, ensure persistence
    def save_to_file(filename)
        tasks_as_hashes = @todo.map(&:to_h)
        File.write(filename, JSON.pretty_generate(tasks_as_hashes))
        puts "Saved to #{filename}"
    end

    # Function to import the to-do list from a file, ensure persistence
    def read_from_file(filename)
        tasks_as_hashes = JSON.parse(File.read(filename), symbolize_names:true)
        @todo = tasks_as_hashes.map { |task_hash| Task.from_h(task_hash) }
        puts "Loaded to #{filename}"
    end

    # Listing out all the tasks you have.
    def list
        puts "Your To-Do List: "
        @todo.each_with_index do |task, index|
            puts "#{index+1}. #{task.name}; Status: #{task.completed} (uid: #{task.id})"
        end
        @todo
    end

    def run 
        loop do 
            puts "\n1. Add Item\n2. List Items\n3. Mark Item as Done\n4. Delete Item\n5. Edit a Task \n6. Save to File \n7. Load from File\n8. Exit"
            print "Choose an option: "
            choice = gets.chomp.to_i

            case choice
            when 1
                print "Enter the task: "
                task = gets.chomp 
                add(task)
            when 2
                puts "List all tasks"
                list
            when 3
                complete
            when 4
                delete
            when 5
                edit
            when 6
                print "What do you want to name the file? Do not include .json."
                name = gets.chomp
                save_to_file(name)
            when 7
                print "What's the name of the file to be loaded? Do not include.json."
                name = gets.chomp
                read_from_file(name)
            when 8 
                puts "Goodbye"
                break
            else
                puts "Invalid choice, please try again!"
            end
        end
    end
end

todo_list = KeepTrackOfToDo.new
todo_list.run

