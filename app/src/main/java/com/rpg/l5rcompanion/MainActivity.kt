package com.rpg.l5rcompanion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Room
import com.rpg.l5rcompanion.database.*
import org.json.JSONArray

class MainActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        parseJSON()
    }


    private fun parseJSON(){
        val db = Room.databaseBuilder(
            applicationContext,
            MyDatabase::class.java, "database-name"
        )
            .allowMainThreadQueries()
            .build()
        val dao = db.l5rCompanionDao()

        /*JSON fo Clans*/
        val clansFile = "clans.json"
        val clansJson: String = applicationContext.assets.open(clansFile).bufferedReader().use{it.readText()}
        val clansJsonArray = JSONArray(clansJson)
        for (i in 0 until clansJsonArray.length()){
            val id = clansJsonArray.getJSONObject(i).getString("uid")
            val name = clansJsonArray.getJSONObject(i).getString("name")
            val type = clansJsonArray.getJSONObject(i).getString("type")
            val mon = clansJsonArray.getJSONObject(i).getString("mon")
            val description = clansJsonArray.getJSONObject(i).getString("description")
            val model = Clans(id.toInt(),name, type,mon, description)
            dao.insertClans(model)
        }

        /*JSON fo Families*/
        val familiesFile = "families.json"
        val familiesJson: String = applicationContext.assets.open(familiesFile).bufferedReader().use{it.readText()}
        val familiesJsonArray = JSONArray(familiesJson)
        for (i in 0 until familiesJsonArray.length()){
            val id = familiesJsonArray.getJSONObject(i).getString("uid")
            val name = familiesJsonArray.getJSONObject(i).getString("name")
            val clan = familiesJsonArray.getJSONObject(i).getString("clan")
            val bonus = familiesJsonArray.getJSONObject(i).getString("bonus")
            val description = familiesJsonArray.getJSONObject(i).getString("description")
            val model = Families(id.toInt(),name, clan, bonus, description)
            dao.insertFamilies(model)
        }

        /*JSON fo Schools*/
        val schoolsFile = "schools.json"
        val schoolsJson: String = applicationContext.assets.open(schoolsFile).bufferedReader().use{it.readText()}
        val schoolsJsonArray = JSONArray(schoolsJson)
        for (i in 0 until schoolsJsonArray.length()) {
            val id = schoolsJsonArray.getJSONObject(i).getString("uid")
            val name = schoolsJsonArray.getJSONObject(i).getString("name")
            val clanId = schoolsJsonArray.getJSONObject(i).getString("clan")
            val discipline = schoolsJsonArray.getJSONObject(i).getString("discipline")
            val benefit = schoolsJsonArray.getJSONObject(i).getString("benefit")
            val skills = schoolsJsonArray.getJSONObject(i).getString("skills")
            val honor = schoolsJsonArray.getJSONObject(i).getString("honor")
            val outfit = schoolsJsonArray.getJSONObject(i).getString("outfit")
            val ringsTraitsRequirement = schoolsJsonArray.getJSONObject(i)
                .getJSONObject(("requirements")).getString("rings/traits")
            val skillsRequirement = schoolsJsonArray.getJSONObject(i)
                .getJSONObject(("requirements")).getString("skills")
            val otherRequirement = schoolsJsonArray.getJSONObject(i)
                .getJSONObject(("requirements")).getString("other")
            val titleRank1 = schoolsJsonArray.getJSONObject(i).getString("titleRank1")
            val titleRank2 = schoolsJsonArray.getJSONObject(i).getString("titleRank2")
            val titleRank3 = schoolsJsonArray.getJSONObject(i).getString("titleRank3")
            val titleRank4 = schoolsJsonArray.getJSONObject(i).getString("titleRank4")
            val titleRank5 = schoolsJsonArray.getJSONObject(i).getString("titleRank5")
            val rank1 = schoolsJsonArray.getJSONObject(i).getString("rank1")
            val rank2 = schoolsJsonArray.getJSONObject(i).getString("rank2")
            val rank3 = schoolsJsonArray.getJSONObject(i).getString("rank3")
            val rank4 = schoolsJsonArray.getJSONObject(i).getString("rank4")
            val rank5 = schoolsJsonArray.getJSONObject(i).getString("rank5")
            val description = schoolsJsonArray.getJSONObject(i).getString("description")
            val type = schoolsJsonArray.getJSONObject(i).getString("type")
            val model = Schools(
                id.toInt(),
                name,
                clanId,
                discipline,
                benefit,
                skills,
                honor,
                outfit,
                ringsTraitsRequirement,
                skillsRequirement,
                otherRequirement,
                titleRank1,
                titleRank2,
                titleRank3,
                titleRank4,
                titleRank5,
                rank1,
                rank2,
                rank3,
                rank4,
                rank5,
                description,
                type
            )
            dao.insertSchools(model)
        }

        /*JSON fo Paths*/
        val pathsFile = "paths.json"
        val pathsJson: String = applicationContext.assets.open(pathsFile).bufferedReader().use{it.readText()}
        val pathsJsonArray = JSONArray(pathsJson)
        for (i in 0 until pathsJsonArray.length()) {
                val idPath = pathsJsonArray.getJSONObject(i).getString("uid")
                val namePath = pathsJsonArray.getJSONObject(i).getString("name")
                val clanIdPath = pathsJsonArray.getJSONObject(i).getString("clan")
                val disciplinePath = pathsJsonArray.getJSONObject(i).getString("discipline")
                val ringsTraitsRequirementPath = pathsJsonArray.getJSONObject(i)
                    .getJSONObject(("requirements")).getString("rings/traits")
                val skillsRequirementPath = pathsJsonArray.getJSONObject(i)
                    .getJSONObject(("requirements")).getString("skills")
                val otherRequirementPath = pathsJsonArray.getJSONObject(i)
                    .getJSONObject(("requirements")).getString("other")
                val techniqueRank = pathsJsonArray.getJSONObject(i).getString("technique rank")
                val replaces = pathsJsonArray.getJSONObject(i).getString("replaces")
                val pathTechniqueTitle =
                    pathsJsonArray.getJSONObject(i).getString("pathTechniqueTitle")
                val pathTechnique = pathsJsonArray.getJSONObject(i).getString("pathTechnique")
                val descriptionPath = pathsJsonArray.getJSONObject(i).getString("description")

                val modelPath = Paths(
                    idPath.toInt(),
                    namePath,
                    clanIdPath,
                    disciplinePath,
                    ringsTraitsRequirementPath,
                    skillsRequirementPath,
                    otherRequirementPath,
                    techniqueRank,
                    replaces,
                    pathTechniqueTitle,
                    pathTechnique,
                    descriptionPath
                )
                dao.insertPaths(modelPath)
        }

        /*JSON fo CategoriesRules*/
        val catRulesFile = "rulescategories.json"
        val catRulesJson: String = applicationContext.assets.open(catRulesFile).bufferedReader().use{it.readText()}
        val catRulesJsonArray = JSONArray(catRulesJson)
        for (j in 0 until catRulesJsonArray.length()){
                val uid = catRulesJsonArray.getJSONObject(j).getString("uid")
                val catName = catRulesJsonArray.getJSONObject(j).getString("name")
                val modelCat = CategoriesRules(uid.toInt(),catName)
                dao.insertCategoriesRules(modelCat)
        }

        /*JSON fo Rules*/
        val rulesFile = "rules.json"
        val rulesJson: String = applicationContext.assets.open(rulesFile).bufferedReader().use{it.readText()}
        val rulesJsonArray = JSONArray(rulesJson)
        for (j in 0 until rulesJsonArray.length()){
                val uid = rulesJsonArray.getJSONObject(j).getString("uid")
                val ruleName = rulesJsonArray.getJSONObject(j).getString("name")
                val content = rulesJsonArray.getJSONObject(j).getString("content")
                val category = rulesJsonArray.getJSONObject(j).getString("category")
                val modelRules = Rules(uid.toInt(),ruleName,content,category)
                dao.insertRules(modelRules)
        }

        /*JSON fo Skills*/
        val skillsFile = "skills.json"
        val skillsJson: String = applicationContext.assets.open(skillsFile).bufferedReader().use{it.readText()}
        val skillsJsonArray = JSONArray(skillsJson)
        for (j in 0 until skillsJsonArray.length()){
            val uid = skillsJsonArray.getJSONObject(j).getString("uid")
            val skillName = skillsJsonArray.getJSONObject(j).getString("name")
            val skillType = skillsJsonArray.getJSONObject(j).getString("type")
            val skillContent = skillsJsonArray.getJSONObject(j).getString("content")
            val skillCategory = skillsJsonArray.getJSONObject(j).getString("category")
            val emphases = skillsJsonArray.getJSONObject(j).getString("emphases")
            val trait = skillsJsonArray.getJSONObject(j).getString("trait")
            val mastery = skillsJsonArray.getJSONObject(j).getString("mastery")
            val modelSkills = Skills(uid.toInt(),skillName,skillType,skillCategory,emphases,trait,skillContent,mastery)
            dao.insertSkills(modelSkills)
        }

        /*JSON fo Spells*/
        val spellsFile = "spells.json"
        val spellsJson: String = applicationContext.assets.open(spellsFile).bufferedReader().use{it.readText()}
        val spellsJsonArray = JSONArray(spellsJson)
        for (j in 0 until spellsJsonArray.length()){
            val uid = spellsJsonArray.getJSONObject(j).getString("uid")
            val nameSpell = spellsJsonArray.getJSONObject(j).getString("name")
            val ring = spellsJsonArray.getJSONObject(j).getString("ring")
            val mastery = spellsJsonArray.getJSONObject(j).getString("mastery")
            val type = spellsJsonArray.getJSONObject(j).getString("type")
            val range = spellsJsonArray.getJSONObject(j).getString("range")
            val area = spellsJsonArray.getJSONObject(j).getString("area")
            val duration = spellsJsonArray.getJSONObject(j).getString("duration")
            val raises = spellsJsonArray.getJSONObject(j).getString("raises")
            val content = spellsJsonArray.getJSONObject(j).getString("content")

            val modelSpells = Spells(uid.toInt(),nameSpell,ring,mastery,type,range,area,duration,raises,content)
            dao.insertSpells(modelSpells)
        }

        /*JSON fo Katas*/
        val katasFile = "katas.json"
        val katasJson: String = applicationContext.assets.open(katasFile).bufferedReader().use{it.readText()}
        val katasJsonArray = JSONArray(katasJson)
        for (j in 0 until katasJsonArray.length()){
            val uid = katasJsonArray.getJSONObject(j).getString("uid")
            val nameKata = katasJsonArray.getJSONObject(j).getString("name")
            val ring = katasJsonArray.getJSONObject(j).getString("ring")
            val mastery = katasJsonArray.getJSONObject(j).getString("mastery")
            val schools = katasJsonArray.getJSONObject(j).getString("schools")
            val description = katasJsonArray.getJSONObject(j).getString("description")

            val modelKatas = Katas(uid.toInt(),nameKata,ring,mastery,schools,description)
            dao.insertKatas(modelKatas)
        }

        /*JSON fo Kihos*/
        val kihosFile = "kihos.json"
        val kihosJson: String = applicationContext.assets.open(kihosFile).bufferedReader().use{it.readText()}
        val kihosJsonArray = JSONArray(kihosJson)
        for (j in 0 until kihosJsonArray.length()){
            val uid = kihosJsonArray.getJSONObject(j).getString("uid")
            val nameKata = kihosJsonArray.getJSONObject(j).getString("name")
            val ring = kihosJsonArray.getJSONObject(j).getString("ring")
            val mastery = kihosJsonArray.getJSONObject(j).getString("mastery")
            val type = kihosJsonArray.getJSONObject(j).getString("type")
            val description = kihosJsonArray.getJSONObject(j).getString("description")

            val modelKihos = Kihos(uid.toInt(),nameKata,ring,mastery,type,description)
            dao.insertKihos(modelKihos)
        }

        /*JSON fo Armors*/
        val armorsFile = "armors.json"
        val armorsJson: String = applicationContext.assets.open(armorsFile).bufferedReader().use{it.readText()}
        val armorsJsonArray = JSONArray(armorsJson)
        for (j in 0 until armorsJsonArray.length()){
            val uid = armorsJsonArray.getJSONObject(j).getString("uid")
            val nameArmor = armorsJsonArray.getJSONObject(j).getString("name")
            val armortn = armorsJsonArray.getJSONObject(j).getString("armorTN")
            val reduction = armorsJsonArray.getJSONObject(j).getString("reduction")
            val price = armorsJsonArray.getJSONObject(j).getString("price")
            val special = armorsJsonArray.getJSONObject(j).getString("special")
            val description = armorsJsonArray.getJSONObject(j).getString("description")

            val modelArmors = Armors(uid.toInt(),nameArmor,armortn,reduction,price,special,description)
            dao.insertArmors(modelArmors)
        }

        /*JSON fo Weapons*/
        val weaponsFile = "weapons.json"
        val weaponsJson: String = applicationContext.assets.open(weaponsFile).bufferedReader().use{it.readText()}
        val weaponsJsonArray = JSONArray(weaponsJson)
        for (j in 0 until weaponsJsonArray.length()){
            val uid = weaponsJsonArray.getJSONObject(j).getString("uid")
            val nameWeapon = weaponsJsonArray.getJSONObject(j).getString("name")
            val type = weaponsJsonArray.getJSONObject(j).getString("type")
            val keywords = weaponsJsonArray.getJSONObject(j).getString("keywords")
            val dr = weaponsJsonArray.getJSONObject(j).getString("dr")
            val strength = weaponsJsonArray.getJSONObject(j).getString("strength")
            val range = weaponsJsonArray.getJSONObject(j).getString("range")
            val price = weaponsJsonArray.getJSONObject(j).getString("price")
            val special = weaponsJsonArray.getJSONObject(j).getString("special")
            val description = weaponsJsonArray.getJSONObject(j).getString("description")

            val modelWeapons = Weapons(uid.toInt(),nameWeapon,type,keywords,dr,strength,range,price,special,description)
            dao.insertWeapons(modelWeapons)
        }
    }
}