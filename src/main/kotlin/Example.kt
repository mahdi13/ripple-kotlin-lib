import io.reactivex.rxkotlin.subscribeBy

fun main(args: Array<String>) {
    val r = Server(Network.Testnet)
    val a = AdminServer(Network.Testnet)

    a.generateKeypair()
        .subscribe { println(it) }

    r.getAccountInfo(GetAccountParams("rVUMcKLEPpUhxcpjnc3irud8YaMUJqUSj"))
        .subscribeBy(
            onNext={
                println("no error:")
                println(it)
            },
            onError={
                println("with error:")
                println(it as? ErrorResponse)
            }
        )

    r.getAccountTrustLines(GetTrustLinesParams("rVUMcKLEPpUhxcpjnc3irud8YaMUJqUSj"))
        .subscribe { println(it) }

    r.submitTx(SubmitTxParams("13lfjhdfkjdhf"))
        .subscribe { println(it) }

    r.getTxInfo(GetTxInfoParams("55C99B26DB61307D6003ADA5946F505D70C06259DE11A6A3CFCB321D4D718C43"))
        .subscribe { println(it) }
}