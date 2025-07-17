document.addEventListener("DOMContentLoaded", () => {
      function fillAZ(selectId) {
        const sel = document.getElementById(selectId);
        const frag = document.createDocumentFragment();
        for (const ch of "ABCDEFGHIJKLMNOPQRSTUVWXYZ") {
          const opt = document.createElement("option");
          opt.value = ch;
          opt.textContent = ch;
          frag.appendChild(opt);
        }
        sel.appendChild(frag);
      }

      fillAZ("inputColumn");
      fillAZ("outputColumn");

        //submit hadler
      document.getElementById("commandForm").addEventListener("submit", event => {
        event.preventDefault();

        const inputColumn  = document.getElementById("inputColumn").value;
        const outputColumn = document.getElementById("outputColumn").value;
        const command      = document.getElementById("command").value;
        const sheet        = luckysheet.getAllSheets()[0];
        const cellsData    = sheet.celldata;

        const dto = { inputColumn, outputColumn, command, rawCells: cellsData };

        fetch("/uploadColumnData", {
          method: "POST",
          headers: { "Content-Type": "application/json" },
          body: JSON.stringify(dto)
        })
        .then(res => res.json())
        .then(sheetData => {
          luckysheet.destroy();
          luckysheet.create({
            container: 'luckysheet',
            lang: 'en',
            showinfobar: false,
            data: sheetData
          });
        })
        .catch(console.error);
      });
    });