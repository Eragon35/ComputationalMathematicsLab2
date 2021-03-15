import Main.answer

import java.io.{FileOutputStream, OutputStreamWriter}
object WriteToFile {

  def write(filename: String): Unit = {
    try {
      val streamWriter = new OutputStreamWriter(new FileOutputStream(filename))
      answer.foreach(x => streamWriter.write(x + "\n")) // Writing to the file each element of collection
      streamWriter.close()
    } catch {
      case e: Throwable => Console.err.println("Problem with writing collection to file\n" + e.getMessage)
    }
  }

}
