package com.example.demo;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;

enum Priority {
	HIGH, MEDIUM, LOW
}

@Command(name = "task-cli", mixinStandardHelpOptions = true, version = "1.0", description = "bebbe")
public class TaskTracker implements Runnable{
	private static User user = new User();
	DataManager dataManager = new DataManager();

	@Parameters(index = "0")
	private String command;

	//Order matters
	@Parameters(index = "1..*")
	private String[] commandArgs;

	//@Option - no matter when we put needed command
	//@Option(names = {"-p", "--priority"}, description = "assigns priorities")
	//private Priority priority = Priority.MEDIUM;

	public static void main(String[] args) {
		DataManager dataManager = new DataManager();
		user = dataManager.load();
		//args to obj, calls run()
		int exitCode = new CommandLine(new TaskTracker()).execute(args);
		System.exit(exitCode);
	}

	@Override
	public void run() {
		int id;
		switch(command) {
			case "add":
				int i = user.add(commandArgs[0]);
				System.out.println("Task added successfully (ID: " + i + ")");
				break;
			case "update":
				id = Integer.parseInt(commandArgs[0]);
				user.update(id, commandArgs[1]);
				break;
			case "delete":
				id = Integer.parseInt(commandArgs[0]);
				user.delete(id);
				break;
			case "mark-in-progress":
				id = Integer.parseInt(commandArgs[0]);
				user.markInProgress(id);
				break;
			case "mark-done":
				id = Integer.parseInt(commandArgs[0]);
				user.markDone(id);
				break;
			case "list":
				if (commandArgs == null) {
					user.list();
				}
				else {
					if (commandArgs[0] == "done") user.listDone();
					if (commandArgs[0] == "todo") user.listToDo();
					if (commandArgs[0] == "in-progress") user.listInProgress();
				}
				break;
			default:
				System.out.println("There is no such command");
		}
		dataManager.store(user);
	}
}
