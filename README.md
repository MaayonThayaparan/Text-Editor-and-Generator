# Text-Editor-and-Generator

## Description: 
- This program has a text editor GUI which has the following features:
     - Spell check
     - Auto-complete
     - Flesch Readability Score
          - Indicates how difficult a passage in English is to read (more info: https://en.wikipedia.org/wiki/Flesch–Kincaid_readability_tests)
          - Equation = 206.835 - 1.015(total words/total sentences) - 84.6(total syllables/total words)
     - Markov text generation

![image](https://github.com/MaayonThayaparan/Text-Editor-and-Generator/assets/43158629/887f3303-c68b-479f-a3cd-31abc010570a)

## Getting Started 

### Dependencies
- Tested on Windows 10
- Requires Java 1.8 JDK (Java SE 8)
- Requires Eclipse 
- Requires e(fx)clipse

### Installation:

1. Download Java 1.8 JDK (Java SE 8)
     - Download at: https://www.oracle.com/java/technologies/downloads/
     - Tested on version Java SE Development Kit 8u381 → x86 Installer (https://www.oracle.com/java/technologies/downloads/#java8-windows)
     - Create a free Oracle account to download.
     - Note down where you save the folder. 
2. Download Eclipse
     - Download at: https://www.eclipse.org/downloads/
3. Open Eclipse
     - In Eclipse select ‘Window’ tab → Select ‘Preferences’ → Expand ‘Java’ → Select ‘Installed JREs’ → Click ‘Search’
     - Navigate to where  you installed the JDK 1.8 directory. Make sure you select the newly installed JDK directory and not the newly installed JRE directory.
     - After a moment, Eclipse should list a second JRE in the ‘Java → Installed JREs’ window. Select the JRE in the newly installed JDK folder and click ‘Apply and Close’
4. Requires e(fx)clipse
     - Go to www.eclipse.org/efxclipse/install.html
     - Under 'For the Ambitious' click 'View details'
     - Follow the on-screen instructions starting at step 2 or 3
5. In the 'Package Explorer' click 'Import Projects'
6. Under 'Git' select 'Projects from Git (with smart import)
7. Select 'Clone URl'
8. Input URL: https://github.com/MaayonThayaparan/Text-Editor-and-Generator.git
9. Click 'Next' then 'Next' and then 'Finish'
10. Select the root project folder in the 'Package Explorer' then click 'Project => Properties => Java Compiler'
11. Select 'Enable project specific settings'
12. Change the 'Compiler compliance level' to 1.8 then click 'Apply and Close'. Click 'Yes' when prompted. 

### Troubleshooting:
- Do the following if you get the following error: “java.lang.UnsupportedClassVersionError:”
     - Ensure root directory is selected in ‘Package Explorer’ → Click ‘Project’ in tool bar → ‘Properties’ → ‘Java Compiler’ → select ‘Use compliance from execution environment ...' → then click ‘Apply and Close’
 
## Executing the Program
- Open project in Eclipse and run the 'src => application => MainApp.java' file.
     - Load Text
          - Use this button to load .txt file into the Text Editor
     - Flesh Index
          - Clicking this button will calculate and display the Flesh Index in the bottom left.
          - This indicates the readability of the text.
     - Edit Distance
          - Clicking this button will prompt user to enter 2 words.
          - After entering both words and clicking 'Ok', user will be displayed a window which shows the number of steps required to go from word 1 to word 2 and display the route taken.
     - Generate Markov Text
          - Clicking this button will open the 'Markov Text Generator' window.
          - Input a numeric value in the 'Number of words' field and click 'Generate Text'
          - The program will take the text inputted in the Text Editor and generate Markov text for the number of words specified.
     - Spelling Suggestions
          - This will highlight words that are not included in the dictionary.
          - If word is missing and needs to be added to dictionary, add word in the "data --> dict.txt' file. 
     - AutoComplete
          - Selecting this checkbox will enable auto-complete which will display as a dropdown with potential words for any new word being typed.
          - Use up and down keys to select a word in drop down and click <ENTER> to select word or use mouse cursor and click.
     - Clear
          - Use this button to clear text in the Text Editor area. 
     

