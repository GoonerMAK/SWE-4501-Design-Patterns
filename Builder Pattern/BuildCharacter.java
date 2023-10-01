public class BuildCharacter {
    public static void main(String[] args)
    {
        Builder characterBuilder = new CharacterBuilder();

        Character character = characterBuilder
                .setHairType("Straight")
                .setHairColor("Brown")
                .setEyes("Blue")
                .setGender("Male")
                .setAge("30")
                .build();

        System.out.println(character);
    }
}

interface Builder {
    Builder setHairType(String hairType);
    Builder setHairColor(String hairColor);
    Builder setEyes(String eyes);
    Builder setSkinTone(String skinTone);
    Builder setFacialHair(String facialHair);
    Builder setGender(String gender);
    Builder setAge(String age);
    Builder setHeight(String height);
    Builder setWeight(String weight);
    Character build();
}


class CharacterBuilder implements Builder {
    private String hairType;
    private String hairColor;
    private String eyes;
    private String skinTone;
    private String facialHair;
    private String gender;
    private String age;
    private String height;
    private String weight;

    @Override
    public Builder setHairType(String hairType) {
        this.hairType = hairType;
        return this;
    }

    @Override
    public Builder setHairColor(String hairColor) {
        this.hairColor = hairColor;
        return this;
    }

    @Override
    public Builder setEyes(String eyes) {
        this.eyes = eyes;
        return this;
    }

    @Override
    public Builder setSkinTone(String skinTone) {
        this.skinTone = skinTone;
        return this;
    }

    @Override
    public Builder setFacialHair(String facialHair) {
        this.facialHair = facialHair;
        return this;
    }

    @Override
    public Builder setGender(String gender) {
        this.gender = gender;
        return this;
    }

    @Override
    public Builder setAge(String age) {
        this.age = age;
        return this;
    }

    @Override
    public Builder setHeight(String height) {
        this.height = height;
        return this;
    }

    @Override
    public Builder setWeight(String weight) {
        this.weight = weight;
        return this;
    }

    @Override
    public Character build() {
        return new Character(hairType, hairColor, eyes, skinTone, facialHair, gender, age, height, weight);
    }
}



class Character
{
    private String HairType;
    private String HairColor;
    private String Eyes;
    private String SkinTone;
    private String FacialHair;
    private String Gender;
    private String Age;
    private String Height;
    private String Weight;

    public Character(String HairType, String HairColor, String Eyes, String SkinTone,
                     String FacialHair, String Gender, String Age, String Height, String Weight)
    {
        this.HairType = HairType;
        this.HairColor = HairColor;
        this.Eyes = Eyes;
        this.SkinTone = SkinTone;
        this.FacialHair = FacialHair;
        this.Gender = Gender;
        this.Age = Age;
        this.Height = Height;
        this.Weight = Weight;
    }


    public String getHairType() {
        return HairType;
    }

    public String getHairColor() {
        return HairColor;
    }

    public String getEyes() {
        return Eyes;
    }

    public String getSkinTone() {
        return SkinTone;
    }

    public String getFacialHair() {
        return FacialHair;
    }

    public String getGender() {
        return Gender;
    }

    public String getAge() {
        return Age;
    }

    public String getHeight() {
        return Height;
    }

    public String getWeight() {
        return Weight;
    }

    @Override
    public String toString() {
        return "Character Created..." + '\n' +
                "HairType: " + HairType + '\n' +
                "HairColor: " + HairColor + '\n' +
                "Eyes: " + Eyes + '\n' +
                "SkinTone: " + SkinTone + '\n' +
                "FacialHair: " + FacialHair + '\n' +
                "Gender: " + Gender + '\n' +
                "Age: " + Age + '\n' +
                "Height: " + Height + '\n' +
                "Weight: " + Weight + '\n';
    }

}