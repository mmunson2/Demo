# Demo

This repository is a compilation of my personal projects with links to the repos they live in. I also put code demos here. Enjoy!

# Mercy Detector

This project combines computer vision with gaming, or at least video streams of a game. The objective is to identify attributes about a game, such as the character that a user is playing, based on only a video stream. This has applications for streaming services such as Twitch who may want to automatically extract information about what a streamer is doing.

![Mercy's Heads Up Display. The 3D modelled weapon moves slightly to show player movement and is subject to lighting effects. Each hero has a unique weapon](https://raw.githubusercontent.com/DaviidK/mercy-detector/main/Documentation/Images/hero_demo.png)

The first person shooter Overwatch was our game of choice for this project, and we attempted to identify characters based on the weapon they held. Because the weapon is 3D modelled, moves slightly when the character sprints or jumps, and is affected by lighting conditions, getting an accurate read was quite challenging.

![Cascade Training Tool. In order to train a cascade classifier model, a tool was created to quickly add metadata to frames of a video about the hero being played](https://raw.githubusercontent.com/mmunson2/demo/main/im/Cascade_Trainer.png)

We started by training a cascade classifier about the features of Overwatch with OpenCV. This required creating a tool for labeling each frame in a video with metadata about the character being played. The above screenshot shows this tool in action, but not the hours we spent labeling video frames. :sweat_smile:
    
Because our envisioned application would require real-time detection, performance was an important metric. The entire project was built in C++, and we cut down the size of the analyzed images considerably. This allowed us to process roughly 30 frames of video per second, enough precision to pick up small actions such as a weapon firing.

![Cascade Training Tool. In order to train a cascade classifier model, a tool was created to quickly add metadata to frames of a video about the hero being played](https://raw.githubusercontent.com/mmunson2/demo/main/im/Hero_Identification.png)

Our hard work paid off! After about a month of development our model could identify certain Overwatch characters with ~80% accuracy. By using a fuzzy logic system, errors in detection were reduced further such that the model wouldn't fluctuate quickly between determinations.  
   
More details about the Mercy Detector Project: https://github.com/DaviidK/mercy-detector
   
Academic paper on our findings: https://github.com/DaviidK/mercy-detector/blob/main/Documentation/Mercy_Detector_Final_Report.pdf



