import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Practise {
    // private static final Logger LOGGER = LoggerFactory.getLogger(Practise.class);

    public static void main(String[] args) throws IOException {

        Files.list(Paths.get(".")).forEach(System.out::println);
        System.out.println("only files");

        // LOGGER.info("contents of directory are {}", Files.list(Paths.get(".")).toArray());
//        Files.list(Paths.get(".")).filter(Files::isRegularFile).forEach(System.out::println);


        Files.newDirectoryStream(Paths.get("."))
                .forEach(System.out::println);


        System.out.println("only xml files");
        Files.newDirectoryStream(
                Paths.get("."),
                path -> path.toString().endsWith(".xml")
        ).forEach(System.out::println);


        System.out.println("Hidden Files");


        File[] files = new File("C:\\Users\\e092911\\Downloads\\OrganizationalEventScoringSystem")
                .listFiles(File::isHidden);

        Stream.of(files).forEach(System.out::println);

        //  LOGGER.info("Hidden files are {}", files);

        //   LOGGER.trace("tracing level");


        String content = "Hello world";

        Files.write(
                Paths.get("C:\\Users\\e092911\\Downloads\\output.txt"),
                content.getBytes()
        );

        try (Stream<String> readLines = Files.lines(Paths.get("C:\\Users\\e092911\\Desktop\\input.txt"))) {
            readLines.forEach(System.out::println);
        }

        Path path = Paths.get(".");

        Path pathTwo = Paths.get("C:\\Users\\e092911\\Desktop", "input.txt");
        try (Stream<String> filteredLines = Files.lines(pathTwo).
                onClose(() -> System.out.println("file is closed"))
                .filter(line -> line.startsWith("1"))) {
            filteredLines.forEach(System.out::println);
        }


        SecureRandom secureRandom = new SecureRandom();
        byte[] randomBytes = new byte[128];
        secureRandom.nextBytes(randomBytes);

//        Stream.of(randomBytes).flatMap(bytes -> Arrays.stream(bytes))
//                .forEach(System.out::println);


        List<List<Integer>> list = Arrays.asList(

                Arrays.asList(1, 2, 4),
                Arrays.asList(5, 6, 7)

        );


        list.stream().flatMap(each -> each.stream()).forEach(System.out::println);

        list.stream().flatMap(Collection::parallelStream).forEach(System.out::println);

        list.stream().map(r -> r).forEach(System.out::println);

        List<Integer> list1 = Arrays.asList(1, 2, 3);
        List<Integer> list2 = Arrays.asList(4, 5, 6);
        List<Integer> list3 = Arrays.asList(7, 8, 9);

        List<List<Integer>> listOfLists = Arrays.asList(list1, list2, list3);

        List<Integer> listOfAllIntegers = listOfLists.stream()
                .flatMap(x -> x.stream())
                .collect(Collectors.toList());


        listOfLists.stream().map(eachList -> eachList).map(eachList -> eachList).forEach(System.out::println);
        //System.out.println(listOfAllIntegers);

        Stream<String> lines = Files.lines(Paths.get("."));


    }
}
