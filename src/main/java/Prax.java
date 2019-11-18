import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.nio.file.attribute.UserPrincipal;
import java.util.List;
import java.util.stream.Stream;

public class Prax {
    public static void main(String[] args) throws IOException {
        String testInput = "testing if copy works";
        InputStream inputStream = new ByteArrayInputStream(testInput.getBytes());
        OutputStream outputStream = new ByteArrayOutputStream();
        String inputFileLoc = "C:\\Users\\e092911\\Desktop";
        String inputFileName = "filestest.txt";
        Path inputPath = Paths.get(inputFileLoc,inputFileName);
        Path movedPath = Paths.get("C:\\Users\\e092911\\Documents\\copied.txt");


        Files.copy(inputStream, inputPath);
        Files.copy(inputPath, outputStream);
        Files.move(inputPath,movedPath);

        List<String> strings = Files.readAllLines(movedPath);
        Stream<String> lines = Files.lines(movedPath);
        byte[] bytes = Files.readAllBytes(movedPath);

        Files.move(movedPath,inputPath);

        String fileContent = new String(Files.readAllBytes(inputPath));
        System.out.println("fileContent = " + fileContent);

        Files.deleteIfExists(inputPath);

        Files.walkFileTree(Paths.get("C:\\Users\\e092911\\Desktop"), new FileVisitor<Path>() {
            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                System.out.println("Pre Visit Directory: "+dir);
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                System.out.println("Visit File: "+file);
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
                System.out.println("Visit Failed File: "+file);
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                System.out.println("Post Visit Directory: "+dir);
                return FileVisitResult.CONTINUE;
            }
        });

        System.exit(0);
        FileTime lastModifiedTime = Files.getLastModifiedTime(Paths.get(inputFileLoc, inputFileName));
        UserPrincipal owner = Files.getOwner(Paths.get(inputFileLoc, inputFileName));

        File file = new File("srinivs");
        Path path = file.toPath();
        file = path.toFile();



    }
}
