import { StrictMode } from "react";
import { createRoot } from "react-dom/client";
//import App from "./App.jsx";
import "./index.css";
import AvansTakas from "./avansTakas.jsx";
// Bootstrap CSS
import "bootstrap/dist/css/bootstrap.min.css";

createRoot(document.getElementById("root")).render(
  <StrictMode>
    <AvansTakas />
  </StrictMode>
);
