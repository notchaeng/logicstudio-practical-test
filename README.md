# Conference Track Management

This program efficiently organizes talks into tracks for a programming conference based on specified time constraints.

## Problem Description

- The conference consists of multiple tracks, each having morning and afternoon sessions.
- Morning sessions start at 9:00 AM and end by 12:00 PM for lunch.
- Afternoon sessions start at 1:00 PM and end in time for the networking event, which can start between 4:00 PM and 5:00 PM.
- Talks can either be of certain lengths in minutes or a "lightning" talk, which lasts for 5 minutes.
- There are no numerical values in talk titles.
- There should be no gaps between sessions.

## Usage

This program takes input in the format of talk titles followed by their durations and outputs the organized tracks for the conference.

## Test Input

"Writing Fast Tests Against Enterprise Rails 60min",
"Overdoing it in Python 45min",
"Lua for the Masses 30min",
"Ruby Errors from Mismatched Gem Versions 45min",
"Common Ruby Errors 45min",
"Rails for Python Developers lightning",
"Communicating Over Distance 60min",
"Accounting-Driven Development 45min",
"Woah 30min",
"Sit Down and Write 30min",
"Pair Programming vs Noise 45min",
"Rails Magic 60min",
"Ruby on Rails: Why We Should Move On 60min",
"Clojure Ate Scala (on my project) 45min",
"Programming in the Boondocks of Seattle 30min",
"Ruby vs. Clojure for Back-End Development 30min",
"Ruby on Rails Legacy App Maintenance 60min",
"A World Without HackerNews 30min",
"User Interface CSS in Rails Apps 30min"


## Setup

- Ensure you have Java 11 (jdk 11.0.23) installed on your system.
- Clone this repository to your local machine.
- Compile the Java files.
- Run the program, providing input as described above.
- The program will output the organized tracks for the conference.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Acknowledgments

- This program was developed to solve a technical test problem.
