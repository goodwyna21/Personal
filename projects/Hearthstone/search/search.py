import csv

def main():
    with open('card_dat.csv', 'rb') as f:
        reader = csv.reader(f)
        data = list(reader)

#cardId,name,cardSet,type,rarity,text,playerClass,locale,mechanics,faction,health,collectible,img,imgGold,attack,race,cost,flavor,artist,howToGet,howToGetGold,durability,elite


    print("Search")
    print(len(data[1]))

    term = raw_input(">")

    for i in range(len(data)):
        if(term in data[i][5]):
            print(data[i][1] + ", " + data[i][4] + ": " + data[i][5])

if __name__ == "__main__":
    main()
