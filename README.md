# com.mike.berezhkov.huawei
## The content
This file consists of my thoughts about the task, argumentation about my decision, and guidelines for installing the projects to touch it yourself. 
### Thought about the task and decisions
First things first, I have newer worked with Xtext and there were no senior colleagues to ask stupid questions related to the current task. I saw, there was a possibility to test the project. I like Test Driven Development, but I had no clue about, what am I doing. So, there are no tests. 
The grammar is unchanged. The example (without comments) works perfectly. 
The gramma and the validator were tested by changing the example. 
The importing part is complex and unobvious for me. So, here goes a detailed description for running all that stuff in Eclipse. 
### How to run the project
1. Clone all 5 projects to your workspace:
-  - https://github.com/YourLeg/com.mike.berezhkov.huawei
-  - https://github.com/YourLeg/com.mike.berezhkov.huawei.ide
-  - https://github.com/YourLeg/com.mike.berezhkov.huawei.tests
-  - https://github.com/YourLeg/com.mike.berezhkov.huawei.ui
-  - https://github.com/YourLeg/com.mike.berezhkov.huawei.ui.tests
2. With all the projects do *File -> Open Projects From File System*. Then choose *Directory* and chose the corresponding folder.
3. The project will contain errors. It is ok.
4. At project **com.mike.berezhkov.huawei** open file *src/com.mike.berezhkov.huawei/CPoCP.xtext*
5. At *Run* choose *Generate CPoCP (2cp) Language Infrastructure* and wait until done.
6. For all the projects make sure that **src-gen** and **xtend-gen** source folders. Right-click *Build Path -> Use as Source Folder*.
7. At *Run* choose *Launch Runtime Eclipse*. There are still errors. I don't know, how to fix it.  Wait until done. It will create a new workspace **runtime-EclipseXtext** near your current one. 
8. Clone [this helper project](https://github.com/YourLeg/AVGGrades) into **runtime-EclipseXtext** workspace. 
9. Add the helper project in the **runtime-EclipseXtext**.
10. Everything is done!!
