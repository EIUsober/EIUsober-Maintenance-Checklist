
  // Get all the cells in the table
  var cells = document.getElementById("myTable").getElementsByTagName("td");

  // Loop through the cells
  for (var i = 0; i < cells.length; i++) {
    // Add a click event listener to frequency cells
    if (i % 9 < 5) {  // Assuming frequency columns are the first 5 in each row
      var label = cells[i].innerHTML;  // Preserve the label
      cells[i].innerHTML = '<button class="invisible-button" onclick="this.innerHTML=\'X\'">' + label + '</button>';

      // Add a double click event listener to frequency cells
      cells[i].addEventListener("dblclick", function() {
        // When a cell is double clicked, remove the "X" and restore the label
        this.innerHTML = '<button class="invisible-button" onclick="this.innerHTML=\'X\'">' + label + '</button>';
      });
    }

    // Add a double click event listener to work week cells
    if (i % 9 >= 7) {  // Assuming work week columns are the last 2 in each row
      cells[i].addEventListener("dblclick", function() {
        // When a cell is double clicked, make it editable
        this.innerHTML = "<div contenteditable='true'>" + this.innerHTML + "</div>";
      });
    }
  }

