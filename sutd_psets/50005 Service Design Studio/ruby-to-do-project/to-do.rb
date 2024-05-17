require 'json'

class KeepTrackOfToDo
    class Task
        def initialize(taskname)
            @name = taskname
            @completed = false
        end

        def done
            @completed = true
        end

        def getName
            @name
        end

        def getCompleted
            @completed
        end

        def to_h
            { name: @name, completed: @completed }
        end

        def self.from_h(hash)
            task = new(hash[:name])
            task.setCompleted(hash[:completed])
            task
          end

        def setName(taskname)
            @name = taskname
        end

        def setCompleted(done)
            if done == true
                @completed = true
            else
                done = false
            end
        end
    end

    def initialize
        @todo = []
    end

    def add(item)
        new_item = Task.new(item)
        @todo << new_item
    end

    def edit(index)

    end

    def complete()
        prompt = "Which item do you want to mark completed?"
        list
        p prompt
        num = gets.chomp.to_i - 1
        if num < getList.length() and num >= 0
            getList[num].setCompleted(true)
        else
            return "Please select a valid number." 
        end 
    end

    def delete()
        prompt = "Which item do you want to delete?"
        list
        p prompt
        num = gets.chomp.to_i - 1
        if num < getList.length() and num >= 0
            getList.delete_at(num)
        else
            return "Number entered is not a valid number"
        end
    end

    def save_to_file(filename)
        tasks_as_hashes = @todo.map(&:to_h)
        File.write(filename, JSON.pretty_generate(tasks_as_hashes))
        puts "Saved to #{filename}"
    end

    def read_from_file(filename)
        tasks_as_hashes = JSON.parse(File.read(filename), symbolize_names:true)
        @todo = tasks_as_hashes.map { |task_hash| Task.from_h(task_hash) }
        puts "Loaded to #{filename}"
    end

    def list
        puts "Your To-Do List: "
        @todo.each_with_index do |task, index|
            puts "#{index+1}. #{task.getName}"
        end
        @todo
    end

    def getList
        @todo
    end
end

# Usage
todo_list = KeepTrackOfToDo.new
todo_list.add("Buy groceries")
todo_list.save_to_file('todos.json')
todo_list.list

# Simulate reloading the application
new_todo_list = KeepTrackOfToDo.new
new_todo_list.read_from_file('todos.json')
new_todo_list.list

