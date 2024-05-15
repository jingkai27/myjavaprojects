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
    end

    def initialize
        @todo = []
    end

    def add(item)
        new_item = Task.new(item)
        @todo << new_item
    end

    def list
        puts "Your To-Do List: "
        @todo.each_with_index do |task, index|
            puts "#{index+1}. #{task.getName}"
        end
        @todo
    end
end

list1 = KeepTrackOfToDo.new
list1.add("Clean the floor")
list1.add("Mop the floor")
p list1.list
