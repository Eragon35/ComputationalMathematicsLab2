import java.nio.file.{Files, Paths}

object FileChecker {
  def check(name: String): Unit = {
    if (name.isEmpty) throw new Exception("\tdude, i need a file's name")
    if (!Files.exists(Paths.get(name))) throw new Exception("\tdude, file doesn't exist")
    if(!Files.isReadable(Paths.get(name))) throw new Exception("\tdude, i can't read the file")
  }
}