# SEMIT
Software Engineering Meets Intelligent Tutoring


This work was carried at UIC (unpaid research while I was a PhD. student) with Prof. Mark Grechanik. The idea was to generate Questions from the Software Artifacts (which is similar to Conceptual Extraction of Questions of Wikipedia paper done in collaboration with Prof. Krishna Chandramouli, Kshitij Gautam and Itika Gupta).


This repository contains:

1. Source Forge Crawler
2. Code/Data/Metadata Extraction Module from Sourceforge API.
3. Code to Convert Abstract Syntax Tree to JSON ( Java Script OBject Notation)
4. Generate Shell scripts that downloads actual files from the Sourceforge server(little tricky to implement since sourceforge doesn't allow access)
5. Data Engineering Module (that preprocesses (transforms unstructured data --> structured data), imports data in a distributed hadoop enviornment to run Map-reduce queries and links source code and organizes source code) 


 All these modules are ready to run and import in Eclipse IDE.
