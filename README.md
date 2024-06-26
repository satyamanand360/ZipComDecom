ZIP File Compression and Decompression Utility
This Java program demonstrates how to compress files into a ZIP archive and how to decompress a ZIP archive using standard Java libraries.

Usage
Prerequisites
JDK (Java Development Kit) is installed on your system.
Basic understanding of Java programming and file operations.
Getting Started
1. Clone the Repository
  git clone https://github.com/yourusername/your-repository.git
cd your-repository
2. Compile the Java Program
  javac ZipComDecom.java
3. Run the Java Program
   java ZipComDecom
Functions
Compressing Files into a ZIP Archive
Uncomment the following lines in ZipComDecom.java to compress files into a ZIP archive:
 // To Compress files into a ZIP file just uncomment this below code
            // CompressZIP() and comment out the decompressZIP()
            compressZIP(Paths.get("CompressedFiles.zip"), Paths.get("TestFile.txt"),
                    Paths.get("Java-Logo.jpg"),
                    Paths.get("IIT_Kharagpur_Logo.svg"));

Paths.get("test.zip"): Specifies the output ZIP file.
Paths.get("test.json"), Paths.get("test.xml"), etc.: Specify the files to be included in the ZIP archive.
Decompressing a ZIP Archive
Uncomment the following lines in ZipComDecom.java to decompress a ZIP archive:

  // To Decompress the ZIP file uncomment this below code decompressZIP() and
            // comment out the compressZIP()
            // decompressZIP(Paths.get("CompressedFiles.zip"), outputDir);

Notes
Ensure the paths to input files and directories are correct.
Handle exceptions appropriately when using in production or critical environments.

