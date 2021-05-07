import BarChart from "components/BarChart";
import Datatable from "components/DataTable";
import DonutChart from "components/DonutChart";
import Footer from "components/Footer";
import Header from "components/Header";

function App() {
  return (
    <>
      <Header />
      <div className="container">
        <h1 className="text-primary py-3"> Dashboard de vendas</h1>

        <div className="row px-3">
          <div className="col-sm-6">
          <h5 className="text-center text-seocndary">Taxa de sucesso</h5>
            <BarChart />
          </div>
          <div className="col-sm-6">
            <h5 className="text-center text-seocndary">Taxa de sucesso</h5>
            <DonutChart />
          </div>
        </div>

        <div className="py-3">
          <h2 className="text-primary">Totas as vendas</h2>
        </div>
        <Datatable />
      </div>
      <Footer />
    </>
  );
}

export default App;
