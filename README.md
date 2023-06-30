# EventMail
This is a plugin which sends an E-Mail to a specific person, everytime a player joins or leaves.

### Setup
You put the EventMail.jar in the plugins folder and restart your server.<br>
After the restart you find a EventMail folder in your plugins folder.
There are 2 files:
- a config file
- a messages file

#### Configuration
#### Config
![Image of the config file](https://github.com/DQMME/EventMail/blob/master/config.png?raw=true)

- hostname - the hostname of your mailserver
- port - the port of your mail server
- username - the username of your mailbox
- password - the password of your mailbox
- sender - the address which sends the email (must be the mail of the mailbox)
- receiver - the person who gets the emails
- enabled_events - which events should trigger an email

#### Messages

![Image of the messages file](https://github.com/DQMME/EventMail/blob/master/messages.png?raw=true)
- player_joined_title & player_left_title - are used in the email's subject
- email_joined & email_left - the actual email which is being sent