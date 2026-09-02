package com.example.demo;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;
import picocli.CommandLine.Option;

enum Priority {
	HIGH, MEDIUM, LOW
}

@Command(name = "task-cli", mixinStandartHelpOptions = true, version = "1.0", description = "bebbe")
public class TaskTracker implements Runnable{
	@Parameters(index = "0")
	private String command;

	//Order matters
	@Parameters(index = "1..*")
	private String[] commandArgs;

	//@Option - no matter when we put needed command
	@Option(names = {"-p", "--priority"}, description = "assigns priorities")
	private Priority priority = Priority.MEDIUM;

	public static void main(String[] args) {
		//args to obj, calls run()
		int exitCode = new CommandLine(new TaskTracker()).execute(args);
		 System.exit(exitCode);
	}

	@Override
	public void run() {
		
	}
}
