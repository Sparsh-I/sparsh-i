import discord
import os
import random

from dotenv import load_dotenv
from discord.utils import get

load_dotenv()
token = os.getenv('DISCORD_TOKEN')

client = discord.Client()

statements = [
    "It is certain.",
    "It is decidedly so.",
    "Without a doubt.",
    "Yes – definitely.",
    "You may rely on it.",
    "As I see it, yes.",
    "Most likely.",
    "Outlook good.",
    "Yes.",
    "Signs point to yes.",
    "Reply hazy, try again.",
    "Ask again later.",
    "Better not tell you now.",
    "Cannot predict now.",
    "Concentrate and ask again.",
    "Don't count on it.",
    "My reply is no.",
    "My sources say no.",
    "Outlook not so good.",
    "Very doubtful."   
]
wrong_question_statements = [
    "That isn't a valid question.",
    "Literally impossible for a bot like me to answer that.",
    "Um, what?",
    "Ask a truth question, I can't answer this.",
    "WRONG, why don't you try again."
]

why_words = [
  "gay",
  "cock",
  "hairy",
  "dick",
  "massage",
  "bulge",
  "cum",
  "semen",
  "pussy",
  "sperm",
  "ass",
  "butt",
  "boobs",
  "titties",
  "phallic", 
  "sex",
  "seggs"
]

why_statements = [
  "What's wrong with you?",
  "Was that really necessary?",
  "Just answer that yourself, 'cause no one cares.",
  "Shut.",
  "...",
  "Go express your fantasies somewhere else."
]

sparsh = [
  "sparsh",
  "Sparsh",
  "spinch",
  "Spinch",
  "spinach",
  "Spinach",
  "bubb",
  "Bubb",
  "bubby",
  "Bubby",
  "fembubby",
  "Fembubby"
]

sparsh_statements = [
  "Who?",
  "** **",
  "Yo, I am an 8 Ball.",
  "Ask questions about yourself dude."
]

#roles
roleName = "DJ"
badRoleName = "MOGOLOVONIO CONNOISSEUR"
badRoleName2 = "Haram"

#help variables
botHelp = "***__Welcome to Magic 8 Bubb__***\n\nType ``8bubb help category`` to get help on a category.\nThe following categories are available:\n\n**8Ball**\nHow to use the Magic 8 Bubb.\n\n**Dice**\nRoll a dice, or maybe two.\n\n**Coin**\nFlip a coin, heads I win, tails you lose (lol jk)."
ballHelp = "**8Ball Help**\n\nTo use this command begin by typing '8bubb', this is then followed by your question and finally '?'.\n\nThe format will be:\n``8bubb <question> ?``"
diceHelp = "**Dice Help**\n\nTo use this command begin by typing '8bubb dice', followed by the number of sides of the die, then  by the number of dice you want to roll.\n__The die can be 6-sided, 12-sided or 20-sided__.\n\nThe format will be:\n``8bubb dice <how many sides> <number of dice>``"
coinHelp = "**Coin Help**\n\nTo use this command begin by typing '8bubb coin', this is then followed by which side of the coin you want to bet on, heads or tails.\n\nThe format will be:\n``8bubb coin <side of coin>``"

@client.event
async def on_ready():
    print('I have logged in as {0.user}'.format(client))

@client.event
async def on_message(message):
    #only responds to messages sent by others
    if message.author == client.user:
        return
    
    msg = message.content

    #8ball w/ wrong questions
    if get(message.author.roles, name=roleName) and message.content.startswith("8bubb"):        
      if msg.startswith("8bubb what"):
          await message.channel.send(random.choice(wrong_question_statements))
      
      elif  msg.startswith("8bubb how"):
          await message.channel.send(random.choice(wrong_question_statements))
      
      elif  msg.startswith("8bubb hows"):
          await message.channel.send(random.choice(wrong_question_statements))
      
      elif  msg.startswith("8bubb when"):
          await message.channel.send(random.choice(wrong_question_statements))
      
      elif  msg.startswith("8bubb why"):
          await message.channel.send(random.choice(wrong_question_statements))

      elif  msg.startswith("8bubb why"):
          await message.channel.send(random.choice(wrong_question_statements))
      
      elif  msg.startswith("8bubb who"):
          await message.channel.send(random.choice(wrong_question_statements))
          
      elif  msg.startswith("8bubb whos"):
          await message.channel.send(random.choice(wrong_question_statements))
      
      elif  msg.startswith("8bubb whose"):
          await message.channel.send(random.choice(wrong_question_statements))
      
      elif  msg.startswith("8bubb which"):
          await message.channel.send(random.choice(wrong_question_statements))

      elif  msg.startswith("8bubb what"):
          await message.channel.send(random.choice(wrong_question_statements))

      elif  msg.startswith("8bubb where"):
          await message.channel.send(random.choice(wrong_question_statements))
      
      elif msg.startswith('8bubb') and msg.endswith('?'):
              await message.channel.send(random.choice(statements))

    elif get(message.author.roles, name=badRoleName) and msg.startswith("8bubb"):
        if any(word in msg for word in why_words):
          await message.channel.send(random.choice(why_statements))

        elif any(word in msg for word in sparsh):
          await message.channel.send(random.choice(sparsh_statements))  
    
        elif msg.startswith("8bubb what"):
            await message.channel.send(random.choice(wrong_question_statements))
        
        elif  msg.startswith("8bubb how"):
            await message.channel.send(random.choice(wrong_question_statements))
        
        elif  msg.startswith("8bubb hows"):
            await message.channel.send(random.choice(wrong_question_statements))
        
        elif  msg.startswith("8bubb when"):
            await message.channel.send(random.choice(wrong_question_statements))
        
        elif  msg.startswith("8bubb why"):
            await message.channel.send(random.choice(wrong_question_statements))

        elif  msg.startswith("8bubb why"):
            await message.channel.send(random.choice(wrong_question_statements))
        
        elif  msg.startswith("8bubb who"):
            await message.channel.send(random.choice(wrong_question_statements))
            
        elif  msg.startswith("8bubb whos"):
            await message.channel.send(random.choice(wrong_question_statements))
        
        elif  msg.startswith("8bubb whose"):
            await message.channel.send(random.choice(wrong_question_statements))
        
        elif  msg.startswith("8bubb which"):
            await message.channel.send(random.choice(wrong_question_statements))

        elif  msg.startswith("8bubb what"):
            await message.channel.send(random.choice(wrong_question_statements))

        elif  msg.startswith("8bubb where"):
            await message.channel.send(random.choice(wrong_question_statements))
        
        elif msg.startswith('8bubb') and msg.endswith('?'):
            await message.channel.send(random.choice(statements))

    elif get(message.author.roles, name=badRoleName2) and msg.startswith("8bubb"):
        if any(word in msg for word in why_words):
          await message.channel.send(random.choice(why_statements))

        elif any(word in msg for word in sparsh):
          await message.channel.send(random.choice(sparsh_statements))
    
        elif msg.startswith("8bubb what"):
            await message.channel.send(random.choice(wrong_question_statements))
        
        elif  msg.startswith("8bubb how"):
            await message.channel.send(random.choice(wrong_question_statements))
        
        elif  msg.startswith("8bubb hows"):
            await message.channel.send(random.choice(wrong_question_statements))
        
        elif  msg.startswith("8bubb when"):
            await message.channel.send(random.choice(wrong_question_statements))
        
        elif  msg.startswith("8bubb why"):
            await message.channel.send(random.choice(wrong_question_statements))

        elif  msg.startswith("8bubb why"):
            await message.channel.send(random.choice(wrong_question_statements))
        
        elif  msg.startswith("8bubb who"):
            await message.channel.send(random.choice(wrong_question_statements))
            
        elif  msg.startswith("8bubb whos"):
            await message.channel.send(random.choice(wrong_question_statements))
        
        elif  msg.startswith("8bubb whose"):
            await message.channel.send(random.choice(wrong_question_statements))
        
        elif  msg.startswith("8bubb which"):
            await message.channel.send(random.choice(wrong_question_statements))

        elif  msg.startswith("8bubb what"):
            await message.channel.send(random.choice(wrong_question_statements))

        elif  msg.startswith("8bubb where"):
            await message.channel.send(random.choice(wrong_question_statements))
        
        elif msg.startswith('8bubb') and msg.endswith('?'):
            await message.channel.send(random.choice(statements))

    #dice roll 6-sided
    if msg.startswith('8bubb dice 6 1'):
        roll = random.randint(1,6)
        await message.channel.send("The die rolled a **" + str(roll) + "**.")

    elif msg.startswith('8bubb dice 6 2'):
        rollOne = random.randint(1,6)
        rollTwo = random.randint(1,6)
        rollSum = rollOne + rollTwo
        await message.channel.send("The first die rolled a **" + str(rollOne) + "**.\nThe second die rolled a **" + str(rollTwo) + "**.\nThe total is **" + str(rollSum) + "**.")

    #dice roll 12-sided
    if msg.startswith('8bubb dice 12 1'):
        roll = random.randint(1,12)
        await message.channel.send("The die rolled a **" + str(roll) + "**.")

    elif msg.startswith('8bubb dice 12 2'):
        rollOne = random.randint(1,12)
        rollTwo = random.randint(1,12)
        rollSum = rollOne + rollTwo
        await message.channel.send("The first die rolled a **" + str(rollOne) + "**.\nThe second die rolled a **" + str(rollTwo) + "**.\nThe total is **" + str(rollSum) + "**.")

    #dice roll 20-sided
    if msg.startswith('8bubb dice 20 1'):
        roll = random.randint(1,20)
        await message.channel.send("The die rolled a **" + str(roll) + "**.")

    elif msg.startswith('8bubb dice 20 2'):
        rollOne = random.randint(1,20)
        rollTwo = random.randint(1,20)
        rollSum = rollOne + rollTwo
        await message.channel.send("The first die rolled a **" + str(rollOne) + "**.\nThe second die rolled a **" + str(rollTwo) + "**.\nThe total is **" + str(rollSum) + "**.")


    #coin flip
    if msg.startswith('8bubb coin heads'):
        heads = 0
        tails = 0

        flip = random.randint(0,1)
        if (flip == 0):
            heads = 1
         
        if (heads == 1):
            await message.channel.send('It was heads. You won!')
        else:
            await message.channel.send('It was tails. You lost!')

    elif msg.startswith('8bubb coin tails'):
        heads = 0
        tails = 0
        
        flip = random.randint(0,1)
        if (flip == 1):
            tails = 1

        if (tails == 1):
            await message.channel.send('It was tails. You won!')
        else:
            await message.channel.send('It was heads. You lost!')

    #bot help
    if msg.startswith('8bubb') and message.content.endswith('help'):
        await message.channel.send(botHelp)
    
    if msg.startswith('8bubb') and message.content.endswith('help 8ball'):
        await message.channel.send(ballHelp)

    if msg.startswith('8bubb') and message.content.endswith('help dice'):
        await message.channel.send(diceHelp)

    if msg.startswith('8bubb') and message.content.endswith('help coin'):
        await message.channel.send(coinHelp)

client.run(os.getenv('DISCORD_TOKEN'))