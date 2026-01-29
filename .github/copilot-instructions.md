# BU Class Files - AI Coding Agent Instructions

## Repository Overview
This is a Boston University coursework archive containing assignments, labs, discussions, and projects across multiple semesters (Fall 2025, Spring 2026). The repository contains mixed academic content: Java programming assignments, Python data science work, Jupyter notebooks, and course notes.

## Project Structure & Organization

### Primary Course Directories
- **CAS CS 112** (Computer Science): Java fundamentals labs (HelloWorld, data structures, recursion, sorting algorithms)
  - `Lab1-Lab7/`: Progressive coding labs with test drivers
  - `PS1-PS4/`: Problem sets with increasing complexity (e.g., BigInt.java)
  - `Md2/`: Sorting algorithms (BubbleSort, InsertionSort, MergeSort, SelectionSort)

- **CDS DS 110** (Data Science): Python fundamentals with Jupyter notebooks
  - `Lectures/`: Complete lesson notebooks with code examples (no solutions available)
  - `Discussions/`: Interactive R notebooks (R0-R3 covering conditions, lists, functions)
  - `inClass Exercises/`: Practice scripts using functions, dictionaries, and data manipulation
  - `Midterm1/`: Exam problems with bar chart and data visualization examples

- **CDS DS 120 / CDS DS 210**: Spring 2026 data science and machine learning courses (HW, Lectures, Projects)

- **CAS WR 120** (Writing): Writing course materials (genre/grant projects)

- **CAS AN 101 / QST SM 131**: Humanities/social science courses with reading assignments and notes

### File Naming Conventions
- Lab assignments: `Lab{N}/` with descriptive Java/Python files
- Problem sets: `PS{N}/` folders with increasing complexity indicators
- Jupyter notebooks: `Lecture{N}{Topic}_{suffix}.ipynb` where `_nosol` = no solution version
- Discussion materials: `R{N}_{Topic}_{Course_Code}_{Semester}.ipynb`
- Exercise files: `exercise{N}.py` or `excersize{N}.py` (note spelling variations)

## Key Technologies & Patterns

### Java (CS 112 Course)
- **Compilation & Execution**: Standard `javac` and `java` commands
- **File Structure**: Typically one public class per file matching filename
- **Testing Pattern**: Test driver files (e.g., `TestDriver.java`) instantiate and test other classes
- **Example**: [Lab5/TestDriver.java](Fall%202025/CAS%20CS%20112/Lab5/TestDriver.java) creates `Cat` and `Animal` objects for testing inheritance
- **OOP Patterns**: Inheritance (`Animal.java` → `Cat.java`), encapsulation, method overriding
- **Algorithms**: Standard sorting (Bubble, Insertion, Merge, Selection) in `Md2/` folder

### Python (DS 110 & DS 120 Courses)
- **Type Hints**: Functions use type annotations (e.g., `def wordprob(word:str, worddict:dict)`)
- **Common Patterns**:
  - Dictionary-based data: `worddict.get(word, 0)` for safe access
  - Iteration with `for` loops over collections
  - Function definitions with descriptive names and variable naming (`denom` for denominator)
- **Data Structures**: Heavy use of dictionaries, lists, and probability calculations
- **Notebooks**: Jupyter notebooks with markdown explanations followed by code cells with expected outputs

### Jupyter Notebooks (Data Science)
- **Structure**: Alternating markdown (explanations) and Python code cells
- **Execution Model**: Cells are sequential; outputs are embedded
- **Common Output Formats**: `application/vnd.code.notebook.stdout`, `text/plain`, `application/vnd.code.notebook.error`
- **Note**: Many lecture notebooks end in `_nosol` (no solution provided as template for learning)

## Developer Workflows

### Java Development
1. **Compilation**: `javac ClassName.java` in the target `Lab{N}/` or `PS{N}/` directory
2. **Execution**: `java ClassName` to run main method or test driver
3. **Testing Pattern**: Run `TestDriver` class to validate implementations across multiple files

### Python Development
1. **Execution**: `python3 exercise{N}.py` for standalone scripts
2. **Jupyter Workflow**: Use VS Code's Jupyter extension or notebook tools to run cells
3. **Type Checking**: Scripts include type hints but no strict enforcement visible

### Security/CTF Content
- `PASS&USER.txt` files (e.g., [Spring 2026/CDS DS 210/HW/HW1/PASS&USER.txt](Spring%202026/CDS%20DS%20210/HW/HW1/PASS&USER.txt)) document Bandit CTF progress
- Contains level-by-level commands used and passwords found
- Pattern: Documents command sequences, outcomes, and credentials for reference

## Important Notes for AI Agents

1. **Mixed Content Type**: This is an education repository. Code quality varies intentionally (teaching progressively complex concepts).
2. **No Build System**: No Maven, Gradle, CMake, or npm. Use direct Java/Python execution.
3. **Notebook Execution**: Jupyter notebooks require notebook runner, not just Python interpreter.
4. **File Organization by Course**: Always understand which course folder a file belongs to for context (Java = CS 112, Python = DS 110/120).
5. **Assignment Progression**: Files demonstrate learning progression - early labs are simpler, later PS (problem sets) more complex.
6. **Variable Naming**: Prioritize clarity over brevity (e.g., `denominator` acceptable, context-specific abbreviations common).
7. **Cross-File Dependencies**: Some assignments have multiple Java files in same folder (e.g., `Animal.java` + `Cat.java`) - check for these relationships.

## Testing & Validation

- **Java Tests**: Look for `TestDriver.java` or `*Test*.java` files in same directory
- **Python Tests**: Check for assertion patterns or simple print validation
- **Expected Output**: Notebook cells show expected output inline; use for validation
