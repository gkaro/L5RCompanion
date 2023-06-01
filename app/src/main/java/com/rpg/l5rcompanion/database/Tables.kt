package com.rpg.l5rcompanion.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Clans")
data class Clans(
    @PrimaryKey var uid: Int,
    @ColumnInfo(name = "name") var name: String,
    @ColumnInfo(name = "type") var type: String,
    @ColumnInfo(name = "mon") var mon: String,
    @ColumnInfo(name = "description") var description: String
)

@Entity(tableName = "Schools")
data class Schools(
    @PrimaryKey var uid: Int,
    @ColumnInfo(name = "name") var name: String,
    @ColumnInfo(name = "clanId") var clanId: String,
    @ColumnInfo(name = "discipline") var discipline: String,
    @ColumnInfo(name = "benefit") var benefit: String,
    @ColumnInfo(name = "skills") var skills: String,
    @ColumnInfo(name = "honor") var honor: String,
    @ColumnInfo(name = "outfit") var outfit: String,
    @ColumnInfo(name = "ringsTraitsRequirement") var ringsTraitsRequirement: String,
    @ColumnInfo(name = "skillsRequirement") var skillsRequirement: String,
    @ColumnInfo(name = "otherRequirement") var otherRequirement: String,
    @ColumnInfo(name = "titleRank1") var titleRank1: String,
    @ColumnInfo(name = "titleRank2") var titleRank2: String,
    @ColumnInfo(name = "titleRank3") var titleRank3: String,
    @ColumnInfo(name = "titleRank4") var titleRank4: String,
    @ColumnInfo(name = "titleRank5") var titleRank5: String,
    @ColumnInfo(name = "rank1") var rank1: String,
    @ColumnInfo(name = "rank2") var rank2: String,
    @ColumnInfo(name = "rank3") var rank3: String,
    @ColumnInfo(name = "rank4") var rank4: String,
    @ColumnInfo(name = "rank5") var rank5: String,
    @ColumnInfo(name = "description") var description: String,
    @ColumnInfo(name = "type") var type: String
)

@Entity(tableName = "Paths")
data class Paths(
    @PrimaryKey var uid: Int,
    @ColumnInfo(name = "name") var name: String,
    @ColumnInfo(name = "clanId") var clanId: String,
    @ColumnInfo(name = "discipline") var discipline: String,
    @ColumnInfo(name = "ringsTraitsRequirementPath") var ringsTraitsRequirement: String,
    @ColumnInfo(name = "skillsRequirementPath") var skillsRequirement: String,
    @ColumnInfo(name = "otherRequirementPath") var otherRequirement: String,
    @ColumnInfo(name = "techniqueRank") var techniqueRank: String,
    @ColumnInfo(name = "replaces") var replaces: String,
    @ColumnInfo(name = "pathTechniqueTitle") var pathTechniqueTitle: String,
    @ColumnInfo(name = "pathTechnique") var pathTechnique: String,
    @ColumnInfo(name = "descriptionPath") var description: String,
)

@Entity(tableName = "Families")
data class Families(
    @PrimaryKey var uid: Int,
    @ColumnInfo(name = "name") var name: String,
    @ColumnInfo(name = "clan") var clan: String,
    @ColumnInfo(name = "bonus") var bonus: String,
    @ColumnInfo(name = "description") var description: String
)


@Entity(tableName = "Rules")
data class Rules(
    @PrimaryKey var uid: Int,
    @ColumnInfo(name = "name") var name: String,
    @ColumnInfo(name = "content") var content: String,
    @ColumnInfo(name = "category") var category: String
)

@Entity(tableName = "CategoriesRules")
data class CategoriesRules(
    @PrimaryKey var uid: Int,
    @ColumnInfo(name = "name") var name: String
)

@Entity(tableName = "Skills")
data class Skills(
    @PrimaryKey var uid: Int,
    @ColumnInfo(name = "name") var name: String,
    @ColumnInfo(name = "type") var type: String,
    @ColumnInfo(name = "category") var category: String,
    @ColumnInfo(name = "emphases") var emphases: String,
    @ColumnInfo(name = "trait") var trait: String,
    @ColumnInfo(name = "content") var content: String,
    @ColumnInfo(name = "mastery") var mastery: String
)

@Entity(tableName = "Spells")
data class Spells(
    @PrimaryKey var uid: Int,
    @ColumnInfo(name = "name") var name: String,
    @ColumnInfo(name = "ring") var ring: String,
    @ColumnInfo(name = "mastery") var mastery: String,
    @ColumnInfo(name = "type") var type: String,
    @ColumnInfo(name = "range") var range: String,
    @ColumnInfo(name = "area") var area: String,
    @ColumnInfo(name = "duration") var duration: String,
    @ColumnInfo(name = "raises") var raises: String,
    @ColumnInfo(name = "content") var content: String
)

@Entity(tableName = "Katas")
data class Katas(
    @PrimaryKey var uid: Int,
    @ColumnInfo(name = "name") var name: String,
    @ColumnInfo(name = "ring") var ring: String,
    @ColumnInfo(name = "mastery") var mastery: String,
    @ColumnInfo(name = "schools") var schools: String,
    @ColumnInfo(name = "description") var description: String,
)

@Entity(tableName = "Kihos")
data class Kihos(
    @PrimaryKey var uid: Int,
    @ColumnInfo(name = "name") var name: String,
    @ColumnInfo(name = "ring") var ring: String,
    @ColumnInfo(name = "mastery") var mastery: String,
    @ColumnInfo(name = "type") var type: String,
    @ColumnInfo(name = "description") var description: String,
)

@Entity(tableName = "Armors")
data class Armors(
    @PrimaryKey var uid: Int,
    @ColumnInfo(name = "name") var name: String,
    @ColumnInfo(name = "armortn") var armortn: String,
    @ColumnInfo(name = "reduction") var reduction: String,
    @ColumnInfo(name = "price") var price: String,
    @ColumnInfo(name = "special") var special: String,
    @ColumnInfo(name = "description") var description: String,
)

@Entity(tableName = "Weapons")
data class Weapons(
    @PrimaryKey var uid: Int,
    @ColumnInfo(name = "name") var name: String,
    @ColumnInfo(name = "type") var type: String,
    @ColumnInfo(name = "keywords") var keywords: String,
    @ColumnInfo(name = "dr") var dr: String,
    @ColumnInfo(name = "strength") var strength: String,
    @ColumnInfo(name = "range") var range: String,
    @ColumnInfo(name = "price") var price: String,
    @ColumnInfo(name = "special") var special: String,
    @ColumnInfo(name = "description") var description: String,
)

@Entity(tableName = "AdvDis")
data class AdvDis(
    @PrimaryKey var uid: Int,
    @ColumnInfo(name = "name") var name: String,
    @ColumnInfo(name = "type") var type: String,
    @ColumnInfo(name = "subtype") var subtype: String,
    @ColumnInfo(name = "points") var points: String,
    @ColumnInfo(name = "description") var description: String,
)

@Entity(tableName = "Stations")
data class Stations(
    @PrimaryKey var uid: Int,
    @ColumnInfo(name = "name") var name: String,
    @ColumnInfo(name = "content") var content: String
)

@Entity(tableName = "Okuden")
data class Okuden(
    @PrimaryKey var uid: Int,
    @ColumnInfo(name = "name") var name: String,
    @ColumnInfo(name = "prerequisite") var prerequisite: String,
    @ColumnInfo(name = "rank1") var rank1: String,
    @ColumnInfo(name = "rank2") var rank2: String,
    @ColumnInfo(name = "rank3") var rank3: String
)