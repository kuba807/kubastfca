import json
składnik= ""
data = {
  "type": "firmalife:vat",
    "input_item": {
    "ingredient":{
      "iteam":
    "tfc:plant/"+składnik
                  }},
  "input_fluid": {
    "ingredient": "minecraft:water",
    "amount": 200
  },
  "output_fluid": {
    "fluid": "kubastfca:tea_"+składnik+"_fluid",
    "amount": 200
  }
}
with open(składnik+'_tea_vat.json', 'w') as file:
    json.dump(data, file)