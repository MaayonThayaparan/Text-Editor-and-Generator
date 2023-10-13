# Earthquake-Interactive-Map

## Description: 
- This program has a text editor GUI which has the following features:
     - Spell check
     - Auto-complete
     - Flesch Readability Score
          - Indicates how difficult a passage in English is to read (more info: https://en.wikipedia.org/wiki/Flesch–Kincaid_readability_tests)
          - 
     - Markov text generation

## Getting Started 

### Dependencies
- Tested on Windows 10
- Requires Java 1.8 JDK (Java SE 8)
     - Download: https://www.oracle.com/java/technologies/downloads/
          - Tested on version Java SE Development Kit 8u381 → x86 Installer (https://www.oracle.com/java/technologies/downloads/#java8-windows)
          - Create a free Oracle account to download.
          - Note down where you save the folder. 
- Requires Eclipse (specifically for next segment)
     - Download: https://www.eclipse.org/downloads/
     - Need to configure the following:
          - Open Eclipse → Select ‘Window’ tab → Select ‘Preferences’ → Expand ‘Java’ → Select ‘Installed JREs’ → Click ‘Search’
          - Navigate to where  you installed the JDK 1.8 directory. Make sure you select the newly installed JDK directory and not the newly installed JRE directory.
          - After a moment, Eclipse should list a second JRE in the ‘Java → Installed JREs’ window. Select the JRE in the newly installed JDK folder and click ‘Apply and Close’ 
     - Switch to Java Compiler 1.6 if you get VM problems (see ‘Troubleshooting’ section)
- Requires e(fx)clipse
     1. Go to www.eclipse.org/efxclipse/install.html
     2. Under 'For the Ambitious' click 'View details'
     3. Follow the on-screen instructions starting at step 2 or 3

### Installation:
1. Download project from GitHub\
2. Create a new Java Project in your workspace
3. File -> Import -> Select "File System" -> Next -> Browse and set 
	  root directory to folder contents of zip were extracted to -> Finish

### Troubleshooting:
- Do the following if you get the following error: “java.lang.UnsupportedClassVersionError:”
     - Ensure root directory is selected in ‘Package Explorer’ → Click ‘Project’ in tool bar → ‘Properties’ → ‘Java Compiler’ → select ‘Use compliance from execution environment ‘JavaSE 1.6’... → then click ‘Apply and Close’
