class Agenda (val meetings: List[Meeting]) {

  def printDaySchedule(day: String): Unit = {
    val meetingsForTheDay = meetings.filter(_.day == day)

    def printSplitDayMeetings(amOrPm: "am" | "pm"): Unit = {
      val portion = if (amOrPm == "am") "morning" else "afternoon"
      println(s"$day $portion:")
      if (meetingsForTheDay.length == 0) println(s"  There are no meetings on $day $portion")
      else meetingsForTheDay.map(m => println(s"  ${m.time}: ${m.name}"))
      println
    }

    if (meetingsForTheDay.length == 0) println(s"$day:\n  There are no meetings on $day\n")
    else {
      printSplitDayMeetings("am")
      printSplitDayMeetings("pm")
    }
  }
}

class Meeting (val name: String, val day: String, val time: String)

object Main extends App {
  val m1 = new Meeting("Retro", "Friday", "5pm")
  val m2 = new Meeting("Yoga", "Tuesday", "10am")
  val m3 = new Meeting("Team Meeting", "Tuesday", "3pm")
  val agenda = new Agenda(List(m1, m2, m3))
  agenda.printDaySchedule("Monday")
  agenda.printDaySchedule("Tuesday")
}