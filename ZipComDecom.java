import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/*
 * @author Satyam Anand
 */

public class ZipComDecom {

    public static void main(String args[]) {
        try {
            // To Compress files into a ZIP file just uncomment this below code
            // CompressZIP() and comment out the decompressZIP()
            compressZIP(Paths.get("CompressedFiles.zip"), Paths.get("TestFile.txt"),
                    Paths.get("Java-Logo.jpg"),
                    Paths.get("IIT_Kharagpur_Logo.svg"));

            // Create the output directory if it does not exist
            Path outputDir = Paths.get("files");
            if (!Files.exists(outputDir)) {
                Files.createDirectory(outputDir);
            }

            // To Decompress the ZIP file uncomment this below code decompressZIP() and
            // comment out the compressZIP()
            // decompressZIP(Paths.get("CompressedFiles.zip"), outputDir);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void compressZIP(Path outputFile, Path... filesToZip) throws IOException {
        try (ZipOutputStream zipOutputStream = new ZipOutputStream(Files.newOutputStream(outputFile))) {
            for (Path file : filesToZip) {
                ZipEntry zipEntry = new ZipEntry(file.getFileName().toString());
                zipOutputStream.putNextEntry(zipEntry);
                Files.copy(file, zipOutputStream);
                zipOutputStream.closeEntry();
            }
        }
    }

    public static void decompressZIP(Path zipFile, Path outputDir) throws IOException {
        try (ZipInputStream zipInputStream = new ZipInputStream(Files.newInputStream(zipFile))) {
            ZipEntry entry;
            while ((entry = zipInputStream.getNextEntry()) != null) {
                Path outputFile = outputDir.resolve(entry.getName());
                Files.copy(zipInputStream, outputFile);
                zipInputStream.closeEntry();
            }
        }
    }
}
