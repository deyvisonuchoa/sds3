import axios from "axios";
import BarChart from "components/BarChart";
import Datatable from "components/DataTable";
import DonutChart from "components/DonutChart";
import Footer from "components/Footer";
import Header from "components/Header";
import { useEffect, useState } from "react";
import { BASE_URL } from "Utils/requests";
import 'pages/Dashboard/styles.css';

export default function Dashboard() {

    const [loading, setLoading] = useState(true);
    const [hasError, setHasError] = useState(false);

    useEffect(() => {
        axios.get(`${BASE_URL}/sales`)
            .catch( () => {
                setHasError(true)
            })
            .finally( () => {
                setLoading(false);
            })
    }, [])



    if (loading) {
        return (
            <>
                <Header />
                <div className="loading">
                    <span>Aguarde enquanto nós carregamos os dados pra você 😅</span>
                 </div>
                <Footer />
            </>
        )
    }

    if (hasError) {
        return (
            <>
                <Header />
                <div className="loading">
                    <span>Ocorreu um erro ao recuperar os dados, tente novamente mais tarde 😢</span>
                 </div>
                <Footer />
            </>
        )
    }

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
    )
}