package com.example.data

import com.example.R
import com.example.model.BlessingCard
import com.example.model.BlessingCategory

object BlessingCardsData {
  val cardsList: List<BlessingCard> = listOf(
    BlessingCard(
      id = 1,
      title = "Bom Dia com a Paz de Deus",
      greeting = "Bom dia! Que a luz do Senhor ilumine os seus passos e renove as suas forças nesta linda manhã.",
      scriptureVerse = "As misericórdias do Senhor são a causa de não sermos consumidos, porque as suas misericórdias não têm fim; novas são cada manhã; grande é a tua fidelidade.",
      scriptureReference = "Lamentações 3:22-23",
      imageResId = R.drawable.img_bom_dia,
      category = BlessingCategory.BOM_DIA
    ),
    BlessingCard(
      id = 2,
      title = "Amanhecer em Vitória",
      greeting = "Bom dia! Comece o seu dia agradecendo ao Criador por mais este fôlego de vida e bênçãos sem medida.",
      scriptureVerse = "Este é o dia que fez o Senhor; regozijemo-nos e alegremo-nos nele.",
      scriptureReference = "Salmos 118:24",
      imageResId = R.drawable.img_bencao_dia,
      category = BlessingCategory.BOM_DIA
    ),
    BlessingCard(
      id = 3,
      title = "Boa Tarde Abençoada",
      greeting = "Boa tarde! Que o Senhor derrame paz e serenidade sobre as suas tarefas e conserve a sua mente em perfeita harmonia.",
      scriptureVerse = "Tu conservarás em paz aquele cuja mente está firme em ti; porque ele confia em ti.",
      scriptureReference = "Isaías 26:3",
      imageResId = R.drawable.img_boa_tarde,
      category = BlessingCategory.BOA_TARDE
    ),
    BlessingCard(
      id = 4,
      title = "Tarde de Paz e Graça",
      greeting = "Boa tarde! Lembre-se de que mesmo nos momentos de cansaço, a presença de Deus é o seu refrigério.",
      scriptureVerse = "O Senhor é o meu pastor, nada me faltará. Deitar-me faz em verdes pastos, guia-me mansamente a águas tranquilas.",
      scriptureReference = "Salmos 23:1-2",
      imageResId = R.drawable.img_boa_tarde,
      category = BlessingCategory.BOA_TARDE
    ),
    BlessingCard(
      id = 5,
      title = "Boa Noite Sob as Asas do Altíssimo",
      greeting = "Boa noite! Entregue as lutas deste dia nas mãos do Pai e descanse sob o abrigo do Onipotente.",
      scriptureVerse = "Aquele que habita no esconderijo do Altíssimo, à sombra do Onipotente descansará. Direi do Senhor: Ele é o meu Deus, o meu refúgio, a minha fortaleza.",
      scriptureReference = "Salmos 91:1-2",
      imageResId = R.drawable.img_boa_noite,
      category = BlessingCategory.BOA_NOITE
    ),
    BlessingCard(
      id = 6,
      title = "Boa Noite em Comunhão",
      greeting = "Boa noite! Que a paz que excede todo o entendimento guarde o seu coração e o seu lar até o amanhecer.",
      scriptureVerse = "O Senhor te abençoe e te guarde; o Senhor faça resplandecer o seu rosto sobre ti e tenha misericórdia de ti; o Senhor sobre ti levante o seu rosto e te dê a paz.",
      scriptureReference = "Números 6:24-26",
      imageResId = R.drawable.img_durma_com_deus,
      category = BlessingCategory.BOA_NOITE
    ),
    BlessingCard(
      id = 7,
      title = "Durma com Deus e Tenha Paz",
      greeting = "Durma com Deus! Descanse tranquilo(a), pois Aquele que guarda a sua vida não tosqueneja nem dorme.",
      scriptureVerse = "Em paz também me deitarei e dormirei, porque só tu, Senhor, me fazes habitar em segurança.",
      scriptureReference = "Salmos 4:8",
      imageResId = R.drawable.img_durma_com_deus,
      category = BlessingCategory.DURMA_COM_DEUS
    ),
    BlessingCard(
      id = 8,
      title = "Sono Suave na Presença Divina",
      greeting = "Durma com Deus! Entregue o seu amanhã ao Senhor. Que os anjos guardem a sua casa nesta noite abençoada.",
      scriptureVerse = "Quando te deitares, não temerás; sim, deitar-te-ás, e o teu sono será suave.",
      scriptureReference = "Provérbios 3:24",
      imageResId = R.drawable.img_boa_noite,
      category = BlessingCategory.DURMA_COM_DEUS
    ),
    BlessingCard(
      id = 9,
      title = "Manhã de Graça e Vitória",
      greeting = "Bom dia! Que a alegria do Senhor seja a sua força em cada decisão e encontro do seu dia.",
      scriptureVerse = "Porque a alegria do Senhor é a vossa força.",
      scriptureReference = "Neemias 8:10",
      imageResId = R.drawable.banner_devotional,
      category = BlessingCategory.BOM_DIA
    ),
    BlessingCard(
      id = 10,
      title = "Paz Interior e Gratidão",
      greeting = "Que a paz de Cristo reine em seu coração e a gratidão seja o hino constante da sua vida.",
      scriptureVerse = "E a paz de Deus, para a qual também fostes chamados em um corpo, domine em vossos corações; e sede agradecidos.",
      scriptureReference = "Colossenses 3:15",
      imageResId = R.drawable.img_bencao_dia,
      category = BlessingCategory.PAZ_E_GRATIDAO
    )
  )

  fun getByCategory(category: BlessingCategory): List<BlessingCard> {
    return if (category == BlessingCategory.TODAS) {
      cardsList
    } else {
      cardsList.filter { it.category == category }
    }
  }
}
