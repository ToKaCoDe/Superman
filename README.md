# Superman
Java task

1. The Story

In the year 2040 and during your annual alumni meeting at the university you and your friends
were wandering around the university recollecting old memories. During your walk and lots of
laughs, you found the mysterious room that you all were always wondering what’s inside and never
had access to. Since the door was now open, you all decided to go inside and have a look.
Inside, you found a weird looking machine that you recognized as a time machine prototype.
Instantly you were all curious to give it a try one by one. You decided to travel to Smallville, Kansas
City during the year 1955 to see the origins of superman and how he was as a kid.
When you arrived there, you were surprised to find out that you are a member of the Kent family,
the family who adopted superman. And the 6 years old superman, Clark, is your young brother.
Your parents are not aware of Clark’s powers, and he is still a child exploring his powers but afraid
to talk about it.
Knowing a lot about him, you choose to help him to harness his powers. So, now the little Clark
counts on you.
In order that no one sees him during the training sessions, you reached a conclusion of training
him underwater. You set up some targets underwater at Smithville lake, and training will be during
nighttime.

2. Assignment

Targets are scattered underwater on a specific area that resembles the city map. Using some
advanced equipment from the future, you’ll tracks his movement and give him voice commands to
reach the different targets.
Your assignment is to implement the control algorithm that will guide him collecting all the targets
on the city map without going out of boundaries.
Young Clark is still learning his powers, so you both agreed on making the training simple by giving
instructions to targets in terms of one direction only and a speed level.
Direction is either North, East, South or West.
Speed is one out of 5 levels (Level 0 = Human running speed – Level 4 = MACH 9350 which is
2000 miles/second which you already know the fastest speed Clark can go on earth without
causing any damage to Earth)
So, one voice command could be: WEST at speed level MACH 9350.
Since Clark is training underwater, you also need to consider drag forces. As drag forces depend
on Clark’s speed, trying to move with a speed of a running human will not let Clark move at all
underwater.
Every second, your location monitoring gadgets give you parameters about Clark. You need to
give him a new voice command. These parameters include a list of targets scattered around the
city map. The goal for Clark is to collect all targets in no particular order.
The training is considered finished when one of the following events occurs:
• all the targets have been collected
• Clark goes out of city boundaries
• the training session lasts longer than 10 minutes or 1200 simulation cycles
Target is collected when Clark coordinates are not further than 2m from the target coordinates.
Do not add/edit implementation code outside “controller” package.

3. Set Up

3.1. Gradle

Remember that gradle commands can be executed in three different ways:
1. When you have Gradle installed: gradle 'command'
2. When working on Windows command line or PowerShell: gradlew.bat \<command>
3. When working on MacOS, Linux or Windows 10 Shell: ./gradlew <command>
In current guide all examples will use the first format that you can adapt if needed.

3.2. Tests

We have provided you a set of unit tests to simplify development of the controller code (You
class). We recommend using your IDE to execute the tests that have been provided but you can
do it from the command line as well. Also, feel free to add more unit tests, if required
• To execute all tests run
gradle test
• To execute single test just run:
gradle test --tests "*SimpleStraightTest.testStraightLineSingleTarget"
If you remove --tests option, then all tests will be run.
• You can also run the tests without simulation visualizations. Just add
-Dsimulator.disable.gui=true to your command line.
Hint: In windows powershell, use -D”simulator.disable.gui”=true

