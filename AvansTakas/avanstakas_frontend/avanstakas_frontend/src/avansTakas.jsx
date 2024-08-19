import { useState, useMemo } from "react";
import { Button, Container, Row, Col, Form } from "react-bootstrap";
import { useTable } from "react-table";
import "./index.css"; // CSS dosyasını import ediyoruz

function AvansTakas() {
  const [selectedDate, setSelectedDate] = useState("");
  const [gridData, setGridData] = useState([]);

  const handleDateChange = (e) => {
    setSelectedDate(e.target.value);
  };

  const handleButtonClick = (action) => {
    console.log(`Performing ${action} for date: ${selectedDate}`);

    // Backend'e istek gönderme kodu
    fetch(`/api/${action}`, {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({ date: selectedDate }),
    })
      .then((response) => response.json())
      .then((data) => {
        setGridData(data);
      })
      .catch((error) => {
        console.error("Error:", error);
      });
  };

  // Tablo sütunları
  const columns = useMemo(
    () => [
      {
        Header: "Avans ID",
        accessor: "avans_id",
      },
      {
        Header: "Müşteri No",
        accessor: "musteri_no",
      },
      {
        Header: "Avans Tutarı",
        accessor: "tutar",
      },
      {
        Header: "Borçlu/Alacaklı",
        accessor: "borclu_alacakli",
      },
      {
        Header: "Dosya No",
        accessor: "dosya",
      },
      {
        Header: "Takas Tarihi",
        accessor: "takas_tarihi",
      },
      {
        Header: "Ödenen Tutar",
        accessor: "odenen_tutar",
      },
      {
        Header: "Havuz Toplam Bakiye",
        accessor: "havuz_toplam_bakiye",
      },
      {
        Header: "Teminat Havuz Toplam Bakiye",
        accessor: "teminathavuz_toplam_bakiye",
      },
      {
        Header: "Serbest Hesap Bakiye",
        accessor: "serbesthesap_bakiye",
      },
      {
        Header: "Teminat Hesap Bakiye",
        accessor: "teminathesap_bakiye",
      },
    ],
    []
  );

  const data = useMemo(() => gridData, [gridData]);

  const { getTableProps, getTableBodyProps, headerGroups, rows, prepareRow } =
    useTable({ columns, data });

  return (
    <Container fluid className="mt-5">
      <Row className="mb-4 align-items-end">
        <Col md={4} className="date-picker">
          <Form.Group controlId="dateInput">
            <Form.Label>İşlem Tarihi</Form.Label>
            <Form.Control
              type="date"
              value={selectedDate}
              onChange={handleDateChange}
            />
          </Form.Group>
        </Col>
        <Col md={8} className="button-group text-end">
          <Button
            variant="primary"
            onClick={() => handleButtonClick("listele")}
            className="me-2 custom-button"
          >
            LİSTELE
          </Button>
          <Button
            variant="primary"
            onClick={() => handleButtonClick("borcKapama")}
            className="me-2 custom-button"
          >
            BORÇ KAPAMA
          </Button>
          <Button
            variant="primary"
            onClick={() => handleButtonClick("cborcKapama")}
            className="me-2 custom-button"
          >
            CBORÇ KAPAMA
          </Button>
          <Button
            variant="primary"
            onClick={() => handleButtonClick("alacakDagitim")}
            className="custom-button"
          >
            ALACAK DAĞITIM
          </Button>
        </Col>
      </Row>

      <Row className="table-container">
        <Col>
          <div className="table-responsive">
            <table
              {...getTableProps()}
              className="table table-striped table-bordered"
            >
              <thead>
                {headerGroups.map((headerGroup, headerGroupIndex) => (
                  <tr
                    {...headerGroup.getHeaderGroupProps()}
                    key={`headerGroup-${headerGroupIndex}`}
                  >
                    {headerGroup.headers.map((column, columnIndex) => (
                      <th
                        {...column.getHeaderProps()}
                        key={`column-${columnIndex}`}
                      >
                        {column.render("Header")}
                      </th>
                    ))}
                  </tr>
                ))}
              </thead>
              <tbody {...getTableBodyProps()}>
                {rows.map((row, rowIndex) => {
                  prepareRow(row);
                  return (
                    <tr {...row.getRowProps()} key={`row-${rowIndex}`}>
                      {row.cells.map((cell, cellIndex) => (
                        <td {...cell.getCellProps()} key={`cell-${cellIndex}`}>
                          {cell.render("Cell")}
                        </td>
                      ))}
                    </tr>
                  );
                })}
              </tbody>
            </table>
          </div>
        </Col>
      </Row>
    </Container>
  );
}

export default AvansTakas;
