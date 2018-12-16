package FrameworkLibraries;

import DataProviders.ConfigFileReader;

public class FileReaderLibrary {
	
	 private static FileReaderLibrary fileReaderManager = new FileReaderLibrary();
	 private static ConfigFileReader configFileReader;
	 
	 private FileReaderLibrary() { }
	 
	 public static FileReaderLibrary getInstance( ) {
		 
		 return fileReaderManager;
	 }
	 
	 public ConfigFileReader getConfigReader() {
		 
		 return (configFileReader == null) ? new ConfigFileReader() : configFileReader;
	 }

}
