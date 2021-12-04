import Day04.Field.Companion.toField

class Day04(raw: List<String>) {

    private val passports: List<Passport> = Passport.parse(raw)

    fun part1(): Int = (Field.values().toList() - Field.Country_ID).let { requiredFields ->
        passports.count { passport ->
            requiredFields.all { passport.containsKey(it) }
        }
    }

    fun part2(): Int = passports.count { passport ->
        Field.values().all { field ->
            field.validate(passport[field])
        }
    }

    private data class Passport(
        val data: Map<Field, String>
    ) : Map<Field, String> by data {

        companion object {

            fun parse(lines: List<String>): List<Passport> = lines.fold(mutableListOf(mutableListOf())) { acc: MutableList<MutableList<String>>, s: String ->
                acc.apply {
                    when {
                        s.isEmpty() -> this.add(mutableListOf())
                        else -> this.last() += s
                    }
                }
            }.map {
                it.flatMap { line: String ->
                    line.split(" ").map { pair -> pair.split(":").let { (key, value) -> key.toField() to value } }
                }
            }.mapNotNull {
                it.takeIf { it.isNotEmpty() }?.toMap()
            }.map {
                Passport(it)
            }

        }

    }

    private enum class Field(private val key: String) {
        Birth_Year("byr") {
            override fun validate(value: String?) = value != null && value.length == 4 && value.all { it.isDigit() } && value.toIntOrNull()?.let { it in 1920..2002 } == true
        },
        Issue_Year("iyr") {
            override fun validate(value: String?) = value != null && value.length == 4 && value.all { it.isDigit() } && value.toIntOrNull()?.let { it in 2010..2020 } == true
        },
        Expiration_Year("eyr") {
            override fun validate(value: String?) = value != null && value.length == 4 && value.all { it.isDigit() } && value.toIntOrNull()?.let { it in 2020..2030 } == true
        },
        Height("hgt") {
            private val regex = """(\d+)(in|cm)""".toRegex()
            override fun validate(value: String?): Boolean {
                value ?: return false
                if (!regex.matches(value)) return false
                val (rawNumber, unit) = regex.find(value)?.destructured ?: return false
                val number = rawNumber.toInt()
                return when (unit) {
                    "cm" -> number in 150..193
                    "in" -> number in 59..76
                    else -> false
                }
            }
        },
        Hair_Color("hcl") {
            private val regex = """#[0-9a-f]{6}""".toRegex()
            override fun validate(value: String?) = value != null && regex.matches(value)
        },
        Eye_Color("ecl") {
            private val colors = listOf("amb", "blu", "brn", "gry", "grn", "hzl", "oth")
            override fun validate(value: String?) = value in colors
        },
        Passport_ID("pid") {
            override fun validate(value: String?) = value != null && value.length == 9 && value.all { it.isDigit() }
        },
        Country_ID("cid") {
            override fun validate(value: String?) = true
        },
        ;

        abstract fun validate(value: String?): Boolean

        companion object {
            fun String.toField() = values().single { it.key == this }
        }

    }

}