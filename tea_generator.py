import json
składnik= "tea"
data = {
  "type": "tfc:pot",
  "ingredients": [
    {
      "item": "tfc:plant/"+składnik
    }
  ],
  "fluid_ingredient": {
    "ingredient": "minecraft:water",
    "amount": 200
  },
  "duration": 2000,
  "temperature": 600,
  "fluid_output": {
    "fluid": "kubastfca:"+składnik+"_fluid",
    "amount": 200
  }
}

with open(składnik+'_1.json', 'w') as file:
    json.dump(data, file)

    data = {
      "type": "tfc:pot",
      "ingredients": [
        {
          "item": "tfc:plant/" + składnik
        },
        {
          "item": "tfc:plant/" + składnik
        }
      ],
      "fluid_ingredient": {
        "ingredient": "minecraft:water",
        "amount": 400
      },
      "duration": 2000,
      "temperature": 600,
      "fluid_output": {
        "fluid": "kubastfca:" + składnik + "_fluid",
        "amount": 400
      }
    }

with open(składnik + '_2.json', 'w') as file:
  json.dump(data, file)

data = {
  "type": "tfc:pot",
  "ingredients": [
    {
      "item": "tfc:plant/" + składnik
    },
    {
      "item": "tfc:plant/" + składnik
    },
    {
      "item": "tfc:plant/" + składnik
    }
  ],
  "fluid_ingredient": {
    "ingredient": "minecraft:water",
    "amount": 600
  },
  "duration": 2000,
  "temperature": 600,
  "fluid_output": {
    "fluid": "kubastfca:" + składnik + "_fluid",
    "amount": 600
  }
}

with open(składnik + '_3.json', 'w') as file:
  json.dump(data, file)

data = {
  "type": "tfc:pot",
  "ingredients": [
    {
      "item": "tfc:plant/" + składnik
    },
    {
      "item": "tfc:plant/" + składnik
    },
    {
      "item": "tfc:plant/" + składnik
    }
,
    {
      "item": "tfc:plant/" + składnik
    }
  ],
  "fluid_ingredient": {
    "ingredient": "minecraft:water",
    "amount": 800
  },
  "duration": 2000,
  "temperature": 600,
  "fluid_output": {
    "fluid": "kubastfca:" + składnik + "_fluid",
    "amount": 800
  }
}

with open(składnik + '_4.json', 'w') as file:
  json.dump(data, file)

data = {
  "type": "tfc:pot",
  "ingredients": [
    {
      "item": "tfc:plant/" + składnik
    },
    {
      "item": "tfc:plant/" + składnik
    },
    {
      "item": "tfc:plant/" + składnik
    }
,
    {
      "item": "tfc:plant/" + składnik
    }
,
    {
      "item": "tfc:plant/" + składnik
    }
  ],
  "fluid_ingredient": {
    "ingredient": "minecraft:water",
    "amount": 1000
  },
  "duration": 2000,
  "temperature": 600,
  "fluid_output": {
    "fluid": "kubastfca:" + składnik + "_fluid",
    "amount": 1000
  }
}

with open(składnik + '_5.json', 'w') as file:
  json.dump(data, file)