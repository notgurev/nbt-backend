import {FieldInput} from "./pages/field-input/FieldInput";
import {YMaps} from "react-yandex-maps/dist/development/react-yandex-maps";
import './App.css';

function App() {
  return (
    <YMaps>
      <div className="App">
        <div>
          <FieldInput/>
        </div>
      </div>
    </YMaps>
  );
}

export default App;
