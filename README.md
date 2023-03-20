# Demo

This repository is a compilation of my personal projects with links to the repos they live in. I also put code demos here. Enjoy!

# Mercy Detector

This project combines computer vision with gaming, or at least video streams of a game. The objective is to identify attributes about a game, such as the character that a user is playing, based on only a video stream. This has applications for streaming services such as Twitch who may want to automatically extract information about what a streamer is doing.

![Mercy's Heads Up Display. The 3D modelled weapon moves slightly to show player movement and is subject to lighting effects. Each hero has a unique weapon](https://raw.githubusercontent.com/DaviidK/mercy-detector/main/Documentation/Images/hero_demo.png)

The first person shooter Overwatch was our game of choice for this project, and we attempted to identify characters based on the weapon they held. Because the weapon is 3D modelled, moves slightly when the character sprints or jumps, and is affected by lighting conditions, getting an accurate read was quite challenging.

![Cascade Training Tool. In order to train a cascade classifier model, a tool was created to quickly add metadata to frames of a video about the hero being played](https://raw.githubusercontent.com/mmunson2/demo/main/im/Cascade_Trainer.png)

We started by training a cascade classifier about the features of Overwatch with OpenCV. This required creating a tool for labeling each frame in a video with metadata about the character being played. The above screenshot shows this tool in action, but not the hours we spent labeling video frames. :sweat_smile:
    
Because our envisioned application would require real-time detection, performance was an important metric. The entire project was built in C++, and we cut down the size of the analyzed images considerably. This allowed us to process roughly 30 frames of video per second, enough precision to pick up small actions such as a weapon firing.

![Output overlay. Text is placed on top of game footage identifying the hero being played and the weapon they're carrying](https://raw.githubusercontent.com/mmunson2/demo/main/im/Hero_Identification.png)

Our hard work paid off! After about a month of development our model could identify certain Overwatch characters with ~80% accuracy. By using a fuzzy logic system, errors in detection were reduced further such that the model wouldn't fluctuate quickly between determinations.  
   
More details about the Mercy Detector Project: https://github.com/DaviidK/mercy-detector
   
Academic paper on our findings: https://github.com/DaviidK/mercy-detector/blob/main/Documentation/Mercy_Detector_Final_Report.pdf

## Terminal Teacher

This is a website that emulates a Unix terminal inside of your browser. It resurrects Banzi Buddy who gives you helpful advice on how to use different commands. I originally built it as a final project for a web design course in JavaScript, but have since refactored it into TypeScript.

![Terminal Teacher - a website to help a user learn the Unix terminal.](https://raw.githubusercontent.com/mmunson2/demo/main/im/Terminal_Teacher.png)

If you want to try it out I've hosted Terminal Teacher on GitHub pages :blush:
https://mmunson2.github.io/TerminalTeacher_TS/  

This is a relatively recent project (March 2023) and I've applied design and code practices that I use in a professional environment. I'd consider this code ready for review if you're looking for a sample. I've also included design documents in the GitHub repository here: 
https://github.com/mmunson2/TerminalTeacher_TS


# 2D Terrain Generator

This project is part of a class in which we implemented a game engine from scratch in Javascript. As a final project we were asked to create an addon to the engine that other developers could use. We took inspiration from 2D voxel games such as Terraria and created a terrain generation module.

![Example of what 2D voxel terrain looks like](https://raw.githubusercontent.com/mmunson2/demo/main/im/Terrain_Example1.png)

Our approach was to stack different kind of blocks on top of each other, creating the stratified layers voxel gamers are familiar with. By drawing circles in random or sinusoidal arrangements on the lowest layer of the stack, bumpy hills and mountains could be created. Finally, by identifying the top block on the stack, we could place trees.

![Another terrain generation example](https://raw.githubusercontent.com/mmunson2/demo/main/im/Terrain_Example2.png)

Because this module was intended to be reusable by other developers, effort was made to make each feature as configurable as possible. In the above example, the same tree generation function is used to create cacti.

More details about the 2D Terrain Generator: https://mmunson2.github.io/GameEngineDesign-FinalProject/public_html/index.html

Visualization of how terrain is created: https://mmunson2.github.io/GameEngineDesign-FinalProject/public_html/demo.html

# Other repositories

This demo is still a work-in-progress so I don't have everything written out yet, but here are some other projects I've been involved in:  
  
A networked tic tac toe game built on React and Firebase, named after my cat Enzo. I had a great time writing the AI (for single player games) in a way that it would occasionaly make a less-than-optimal move:  
https://github.com/mmunson2/EnzoTicTacToe  

DinoText - a tool for game developers that assists in making dynamically generated dialgoue. 
https://github.com/mmunson2/DinoText
