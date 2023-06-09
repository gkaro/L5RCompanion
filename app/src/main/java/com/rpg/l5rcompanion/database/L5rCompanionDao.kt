package com.rpg.l5rcompanion.database

import androidx.room.*

@Dao
interface L5rCompanionDao{

    @Query("SELECT * FROM Clans")
    fun getAllClans() : List<Clans>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertClans(vararg clans: Clans)

    @Query("SELECT * FROM Families")
    fun getAllFamilies() : List<Families>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertFamilies(vararg families: Families)

    @Query("SELECT * FROM Families WHERE clan= :uid")
    fun getFamiliesByClan(uid: Int): List<Families>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertSchools(vararg schools: Schools)

    @Query("SELECT * FROM Schools")
    fun getAllSchools() : List<Schools>

    @Query("SELECT * FROM Schools WHERE clanId= :uid")
    fun getSchoolsFromClan(uid: Int): List<Schools>

    @Query("SELECT * FROM Schools WHERE clanId= :uid AND type= 'Basic'")
    fun getBasicSchoolsFromClan(uid: Int): List<Schools>

    @Query("SELECT * FROM Schools WHERE clanId= :uid AND type= 'Advanced'")
    fun getAdvSchoolsFromClan(uid: Int): List<Schools>



    @Query("SELECT * FROM Clans WHERE uid= :uid")
    fun getDetailsFromClan(uid: Int): List<Clans>

    @Query("SELECT * FROM Schools WHERE uid= :uid")
    fun getDetailsFromSchool(uid: Int): List<Schools>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPaths(vararg paths: Paths)

    @Query("SELECT * FROM Paths")
    fun getAllPaths() : List<Paths>

    @Query("SELECT * FROM Paths WHERE clanId= :uid")
    fun getPathsFromClan(uid: Int): List<Paths>

    @Query("SELECT * FROM Paths WHERE uid= :uid")
    fun getDetailsFromPath(uid: Int): List<Paths>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCategoriesRules(vararg categoriesRules: CategoriesRules)

    @Query("SELECT * FROM CategoriesRules")
    fun getAllCategoriesRules() : List<CategoriesRules>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertRules(vararg rules: Rules)

    @Query("SELECT * FROM Rules WHERE category= :uid")
    fun getRulesByCategory(uid: Int): List<Rules>

    @Query("SELECT * FROM Rules WHERE uid= :uid")
    fun getRulesById(uid: Int): List<Rules>



    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertSkills(vararg skills: Skills)

    @Query("SELECT * FROM Skills WHERE category= :uid")
    fun getSkillsByCategory(uid: Int): List<Skills>

    @Query("SELECT * FROM Skills")
    fun getAllSkills():List<Skills>

    @Query("SELECT * FROM Skills WHERE uid= :uid")
    fun getSkillsById(uid: Int): List<Skills>



    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertSpells(vararg spells: Spells)

    @Query("SELECT * FROM Spells WHERE mastery= :uid AND ring= :ring")
    fun getSpellsByMasteryandRing(uid: Int,ring:Int): List<Spells>

    @Query("SELECT * FROM Spells WHERE ring= :uid")
    fun getSpellsByRing(uid: Int): List<Spells>

    @Query("SELECT * FROM Spells WHERE uid= :uid")
    fun getSpellsById(uid: Int): List<Spells>



    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertKatas(vararg katas: Katas)

    @Query("SELECT * FROM Katas")
    fun getAllKatas() : List<Katas>

    @Query("SELECT * FROM Katas WHERE uid= :uid")
    fun getKatasById(uid: Int): List<Katas>

    @Query("SELECT * FROM Katas WHERE ring= :ring")
    fun getKatasByRing(ring: String): List<Katas>



    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertKihos(vararg kihos: Kihos)

    @Query("SELECT * FROM Kihos")
    fun getAllKihos() : List<Kihos>

    @Query("SELECT * FROM Kihos WHERE uid= :uid")
    fun getKihosById(uid: Int): List<Kihos>

    @Query("SELECT * FROM Kihos WHERE ring= :ring")
    fun getKihosByRing(ring: String): List<Kihos>



    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertArmors(vararg armors: Armors)

    @Query("SELECT * FROM Armors")
    fun getAllArmors() : List<Armors>

    @Query("SELECT * FROM Armors WHERE uid= :uid")
    fun getArmorsById(uid: Int): List<Armors>



    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertWeapons(vararg weapons: Weapons)

    @Query("SELECT * FROM Weapons")
    fun getAllWeapons() : List<Weapons>

    @Query("SELECT * FROM Weapons WHERE type= :type")
    fun getWeaponsByType(type: String): List<Weapons>

    @Query("SELECT * FROM Weapons WHERE uid= :uid")
    fun getWeaponsById(uid: Int): List<Weapons>



    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAdvDis(vararg advDis: AdvDis)

    @Query("SELECT * FROM AdvDis WHERE type= :type")
    fun getAdvDisByType(type: String): List<AdvDis>

    @Query("SELECT * FROM AdvDis WHERE uid= :uid")
    fun getAdvDisById(uid: Int): List<AdvDis>



    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertStations(vararg stations: Stations)

    @Query("SELECT * FROM Stations WHERE uid= :uid")
    fun getStationById(uid: Int): List<Stations>



    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertOkuden(vararg okuden: Okuden)

    @Query("SELECT * FROM Okuden")
    fun getAllOkuden() : List<Okuden>

    @Query("SELECT * FROM Okuden WHERE uid= :uid")
    fun getOkudenById(uid: Int): List<Okuden>
}