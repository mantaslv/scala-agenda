class Agenda (val meetings: List[Meeting]) {

  def printDaySchedule(day: String): Unit = {
    def printSplitDayMeetings(morningOrAfternoon: "morning" | "afternoon", meetings: List[Meeting]): Unit = {
      println(s"$day $morningOrAfternoon:")
      if (meetings.length == 0) println(s"  There are no meetings on $day $morningOrAfternoon")
      else meetings.map(m => println(s"  ${m.time}: ${m.name}"))
      println
    }

    val meetingsForTheDay = meetings.filter(_.day == day)
    if (meetingsForTheDay.length == 0) println(s"$day:\n  There are no meetings on $day\n")
    else {
      val meetingsForTheMorning = meetingsForTheDay.filter(_.time.takeRight(2) == "am")
      val meetingsForTheAfternoon = meetingsForTheDay.filter(_.time.takeRight(2) == "pm")

      printSplitDayMeetings("morning", meetingsForTheMorning)
      printSplitDayMeetings("afternoon", meetingsForTheMorning)
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