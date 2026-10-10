package com.example.data

import com.example.model.Devotional
import com.example.model.DevotionalCategory
import java.util.Calendar

object DevotionalsData {
  val devotionalsList: List<Devotional> = listOf(
    Devotional(
      id = 1,
      dayOfYear = 1,
      title = "A Paz que Excede Todo Entendimento",
      category = DevotionalCategory.PAZ,
      keyVerseText = "Não estejais inquietos por coisa alguma; antes, as vossas petições sejam em tudo conhecidas diante de Deus, pela oração e súplicas, com ação de graças. E a paz de Deus, que excede todo o entendimento, guardará os vossos corações e os vossos sentimentos em Cristo Jesus.",
      keyVerseReference = "Filipenses 4:6-7",
      reflectionParagraphs = listOf(
        "Vivemos em um mundo acelerado, onde as pressões do dia a dia frequentemente tentam roubar a nossa tranquilidade. Ansiedade sobre o amanhã, incertezas financeiras e preocupações familiares podem nos sobrecarregar se permitirmos.",
        "Contudo, a Palavra nos convida a um refúgio seguro: a oração sincera combinada com gratidão. Quando entregamos nossas causas a Deus, Ele não nos promete a ausência de tempestades no mundo exterior, mas nos oferece uma âncora inabalável em nosso interior: uma paz sobrenatural.",
        "Essa paz não é fruto de circunstâncias favoráveis, mas da presença viva do próprio Deus em nós. Confie hoje que Aquele que cuida das aves do céu e veste os lírios do campo conhece cada necessidade do seu coração."
      ),
      guidedPrayer = "Senhor Deus Todo-Poderoso, coloco diante de Ti todas as minhas inquietações e ansiedades deste dia. Substitui o aperto do meu coração pela Tua paz celestial. Que a certeza do Teu cuidado guarde os meus pensamentos e me conceda serenidade para caminhar. Em nome de Jesus, Amém.",
      practicalAction = "Respire fundo, pare por 5 minutos em silêncio e escreva três motivos reais pelos quais você é grato a Deus hoje."
    ),
    Devotional(
      id = 2,
      dayOfYear = 2,
      title = "Fé para Mover Montanhas",
      category = DevotionalCategory.FE,
      keyVerseText = "Ora, a fé é o firme fundamento das coisas que se esperam, e a prova das coisas que se não veem.",
      keyVerseReference = "Hebreus 11:1",
      reflectionParagraphs = listOf(
        "A fé não é uma mera expectativa positiva ou um pensamento otimista; é a certeza convicta plantada pelo Espírito Santo de que as promessas do Todo-Poderoso jamais falharão.",
        "Muitas vezes, olhamos para as circunstâncias visíveis e elas parecem contrárias. Todavia, os heróis da fé andaram não pelo que viam com os olhos naturais, mas pelo que contemplavam com os olhos da confiança em Deus.",
        "Mesmo quando o mar parecer fechado à sua frente ou a fornalha estiver ardendo, lembre-se: Deus opera no invisível. Cada passo dado em obediência abre caminhos no deserto."
      ),
      guidedPrayer = "Pai Celestial, fortalece a minha fé quando minhas forças fraquejarem. Ajuda-me a enxergar além das dificuldades temporárias e a repousar plenamente nas Tuas promessas eternas. Que a minha vida seja um testemunho da Tua fidelidade. Amém.",
      practicalAction = "Identifique uma situação que você temia e declare em voz alta: 'Eu confio no Senhor, pois para Deus nada é impossível'."
    ),
    Devotional(
      id = 3,
      dayOfYear = 3,
      title = "O Amor que Tudo Suporta",
      category = DevotionalCategory.AMOR,
      keyVerseText = "O amor é sofredor, é benigno; o amor não é invejoso; o amor não trata com leviandade, não se ensoberbece. Não se porta com indecência, não busca os seus interesses, não se irrita, não suspeita mal; não folga com a injustiça, mas folga com a verdade; tudo sofre, tudo crê, tudo espera, tudo suporta.",
      keyVerseReference = "1 Coríntios 13:4-7",
      reflectionParagraphs = listOf(
        "O apóstolo Paulo nos ensina que o verdadeiro amor não é um mero sentimento passageiro, mas uma escolha diária de bondade, paciência e altruísmo.",
        "Em um mundo onde prevalece o egoísmo e o rancor, somos chamados a ser o reflexo do amor de Cristo. Amar quem nos ama é simples, mas manifestar graça àqueles que nos ferem exige a virtude que só o céu pode dar.",
        "Quando perdoamos e decidimos agir com mansidão, desarmamos as armadilhas do ódio e permitimos que a luz do Evangelho resplandeça em nossos lares e relacionamentos."
      ),
      guidedPrayer = "Amado Deus, derrama em meu coração a plenitude do Teu amor. Ensina-me a ser paciente com os defeitos alheios, a perdoar de coração sincero e a estender a mão aos que necessitam de acolhimento. Transforma-me em instrumento da Tua reconciliação. Amém.",
      practicalAction = "Envie uma mensagem de carinho ou perdão para alguém da família ou amigo com quem você não conversa há tempos."
    ),
    Devotional(
      id = 4,
      dayOfYear = 4,
      title = "Planos de Paz e Esperança",
      category = DevotionalCategory.ESPERANCA,
      keyVerseText = "Porque eu bem sei os pensamentos que tenho a vosso respeito, diz o Senhor; pensamentos de paz, e não de mal, para vos dar o fim que esperais.",
      keyVerseReference = "Jeremias 29:11",
      reflectionParagraphs = listOf(
        "Mesmo durante o doloroso exílio do povo em Babilônia, Deus enviou esta mensagem consoladora através do profeta Jeremias: Ele nunca esqueceu os Seus filhos.",
        "Se o momento presente parece confuso ou marcado por incertezas, saiba que os desígnios do Senhor a seu respeito não são de ruína. Ele está moldando o seu caráter e preparando um futuro abençoado.",
        "A esperança bíblica é uma âncora firme da alma (Hb 6:19). Ela não decepciona porque está alicerçada no Deus que não mente nem muda."
      ),
      guidedPrayer = "Senhor Todo-Poderoso, quando o amanhã me trouxer dúvidas, lembra-me de que o meu futuro está guardado em Tuas mãos amorosas. Renova a minha esperança e consola o meu coração com as Tuas doces promessas. Em Cristo Jesus, Amém.",
      practicalAction = "Lembre-se de um livramento ou bênção recebida no passado e agradeça a Deus por Sua constante providência."
    ),
    Devotional(
      id = 5,
      dayOfYear = 5,
      title = "Bendize, ó Minha Alma, ao Senhor",
      category = DevotionalCategory.GRATIDAO,
      keyVerseText = "Bendize, ó minha alma, ao Senhor, e tudo o que há em mim bendiga o seu santo nome. Bendize, ó minha alma, ao Senhor, e não te esqueças de nenhum de seus benefícios.",
      keyVerseReference = "Salmos 103:1-2",
      reflectionParagraphs = listOf(
        "A gratidão tem o poder miraculoso de mudar a nossa perspectiva sobre a vida. Quando focamos nas faltas, alimentamos o desânimo; mas quando relembramos as misericórdias divinas, nossa alma se enche de vigor.",
        "Davi ordenava à sua própria alma que bendissesse ao Senhor. Mesmo nos dias cinzentos, há inúmeros benefícios divinos: o ar que respiramos, o pão cotidiano, a saúde, a salvação da nossa alma e a fidelidade divina que se renova a cada manhã.",
        "Fazer da gratidão um hábito espiritual transforma a oração de mera súplica em uma vibrante canção de adoração."
      ),
      guidedPrayer = "Senhor Deus, meu coração transborda de gratidão por tudo quanto tens feito por mim. Perdoa-me pelos momentos de murmuração. Abre meus olhos para reconhecer a Tua generosidade em cada detalhe simples deste dia. Louvado seja o Teu Santo Nome para sempre. Amém.",
      practicalAction = "Ao longo deste dia, antes de fazer qualquer pedido a Deus, agradeça primeiro por três bênçãos concedidas."
    ),
    Devotional(
      id = 6,
      dayOfYear = 6,
      title = "A Sabedoria que Vem do Alto",
      category = DevotionalCategory.SABEDORIA,
      keyVerseText = "E, se algum de vós tem falta de sabedoria, peça-a a Deus, que a todos dá liberalmente, e o não lança em rosto, e ser-lhe-á dada.",
      keyVerseReference = "Tiago 1:5",
      reflectionParagraphs = listOf(
        "Tomar decisões importantes na vida pode ser um desafio vertiginoso. Muitas vezes nos apoiamos no nosso próprio entendimento e colhemos tropeços.",
        "Tiago nos revela uma promessa maravilhosa: o Deus criador do universo tem prazer em conceder sabedoria aos Seus filhos. Ele não cobra nem censura nossa pequenez; Ele dá generosamente àquele que pede com fé sincera.",
        "A sabedoria divina é pura, pacífica, moderada, tratável, cheia de misericórdia e de bons frutos. Busque a orientação do Senhor antes de assinar papéis, responder com pressa ou tomar rumos decisivos."
      ),
      guidedPrayer = "Pai Celeste, Fonte de toda a sabedoria e luz, guia os meus passos e ilumina o meu entendimento. Dá-me discernimento para escolher o que agrada ao Teu coração e livra-me dos enganos deste mundo. Conduze-me pelo Teu caminho perfeito. Amém.",
      practicalAction = "Antes de tomar qualquer decisão importante hoje, faça uma oração pedindo direção e leia um capítulo do livro de Provérbios."
    ),
    Devotional(
      id = 7,
      dayOfYear = 7,
      title = "Renovados como a Águia",
      category = DevotionalCategory.VITORIA,
      keyVerseText = "Mas os que esperam no Senhor renovarão as forças, subirão com asas como águias; correrão, e não se cansarão; caminharão, e não se fatigarão.",
      keyVerseReference = "Isaías 40:31",
      reflectionParagraphs = listOf(
        "O cansaço físico e emocional é uma realidade humana. Até os jovens se cansam e os moços cambaleiam, nos diz o profeta Isaías. Mas há uma fonte inesgotável de vigor espiritual à nossa disposição.",
        "Esperar no Senhor não significa cruzar os braços com passividade; é colocar a expectativa de socorro exclusivamente em Deus. É saber que quando nossas forças chegam ao fim, o poder de Deus começa a operar.",
        "Assim como a águia aproveita as correntes de ar para voar acima das nuvens de tempestade, aquele que espera no Senhor se ergue acima das aflições cotidianas pela graça divina."
      ),
      guidedPrayer = "Senhor Deus, confesso que me sinto cansado e fraco em minhas próprias forças. Mas venho a Ti, Rocha da minha salvação, para ser renovado. Enche-me do Teu Santo Espírito, dá-me asas espirituais e sustenta os meus passos na jornada. Em Cristo Jesus, Amém.",
      practicalAction = "Descanse sua mente das redes sociais e desfrute de 15 minutos em meditação nas palavras do Salmo 121."
    ),
    Devotional(
      id = 8,
      dayOfYear = 8,
      title = "No Esconderijo do Altíssimo",
      category = DevotionalCategory.CONSOLO,
      keyVerseText = "Aquele que habita no esconderijo do Altíssimo, à sombra do Onipotente descansará. Direi do Senhor: Ele é o meu Deus, o meu refúgio, a minha fortaleza, e nele confiarei.",
      keyVerseReference = "Salmos 91:1-2",
      reflectionParagraphs = listOf(
        "O Salmo 91 nos convida a uma intimidade profunda com Deus: habitar no 'esconderijo' do Altíssimo. Não se trata de uma visita ocasional aos domingos, mas de fazer da presença de Deus a nossa morada constante.",
        "Estar debaixo da sombra do Onipotente garante que nenhuma seta maligna, nenhuma peste ou perigo nos destruirá. Sob Suas asas encontramos proteção, calor e socorro bem presente na angústia.",
        "Se você se sente desprotegido ou vulnerável diante dos desafios da vida, lembre-se: Deus é a sua muralha invencível. Ele guarda a sua entrada e a sua saída desde agora e para sempre."
      ),
      guidedPrayer = "Ó Senhor meu Deus, refugio-me debaixo das Tuas asas protetoras. Livra-me do laço do passarinheiro e da peste perniciosa. Guarda a minha família, o meu lar e a minha mente com a presença dos Teus anjos ministradores. Tu és a minha fortaleza. Amém.",
      practicalAction = "Leia o Salmo 91 em voz alta em seu quarto ou com seus familiares, consagrando o seu lar à proteção de Deus."
    ),
    Devotional(
      id = 9,
      dayOfYear = 9,
      title = "A Doce Voz do Bom Pastor",
      category = DevotionalCategory.PAZ,
      keyVerseText = "O Senhor é o meu pastor, nada me faltará. Deitar-me faz em verdes pastos, guia-me mansamente a águas tranquilas. Refrigera a minha alma; guia-me pelas veredas da justiça, por amor do seu nome.",
      keyVerseReference = "Salmos 23:1-3",
      reflectionParagraphs = listOf(
        "Davi conhecia por experiência própria o trabalho de um pastor: proteger as ovelhas dos lobos, conduzi-las aos pastos verdejantes e tirá-las das águas turbulentas para riachos calmos onde possam beber sem medo.",
        "Jesus afirmou: 'Eu sou o bom Pastor; o bom Pastor dá a sua vida pelas ovelhas' (Jo 10:11). Ele conhece você pelo nome, entende as suas fragilidades e nunca o abandonará no vale da sombra da morte.",
        "Ter o Senhor como pastor é ter a garantia de que nada do que é verdadeiramente essencial para a vida e piedade faltará à sua caminhada."
      ),
      guidedPrayer = "Senhor Jesus, meu Amado e Bom Pastor, guia os meus pensamentos e vontades neste dia. Conduze-me às águas mansas do Teu Espírito e refrigera a minha alma cansada. Confio no Teu cajado e no Teu bordão que me consolam. Amém.",
      practicalAction = "Dedique momentos de contemplação ao ar livre, agradecendo a Jesus por cuidar de cada detalhe da sua vida."
    ),
    Devotional(
      id = 10,
      dayOfYear = 10,
      title = "A Força da Oração Secreta",
      category = DevotionalCategory.ORACAO,
      keyVerseText = "Mas tu, quando orares, entra no teu aposento e, fechando a tua porta, ora a teu Pai que está em secreto; e teu Pai, que vê em secreto, te recompensará publicamente.",
      keyVerseReference = "Mateus 6:6",
      reflectionParagraphs = listOf(
        "No Sermão da Montanha, Jesus nos ensinou que a oração mais poderosa não é a que busca os aplausos humanos, mas aquela que acontece no silêncio do coração sincero.",
        "Quando entramos em nosso quarto, fechamos a porta e conversamos com o Pai com total transparência, sem máscaras ou artifícios, Ele Se inclina para nos ouvir com ternura indizível.",
        "Grandes vitórias espirituais são forjadas primeiramente de joelhos no secreto. Ali as lágrimas se transformam em cânticos de vitória e o medo se dissipa diante da glória do Senhor."
      ),
      guidedPrayer = "Pai Amado, que estás nos céus e no secreto do meu coração, ensina-me a amar esses momentos a sós contigo. Quero derramar a minha alma em Tua presença com sinceridade e fé. Ouve a minha oração e opera segundo o Teu beneplácito. Amém.",
      practicalAction = "Separe 10 minutos hoje para orar com a porta fechada, sem o celular por perto, apenas abrindo o coração a Deus."
    )
  )

  fun getTodayDevotional(): Devotional {
    val dayOfYear = Calendar.getInstance().get(Calendar.DAY_OF_YEAR)
    val index = (dayOfYear - 1) % devotionalsList.size
    return devotionalsList[index]
  }

  fun getByTheme(category: DevotionalCategory): List<Devotional> {
    return devotionalsList.filter { it.category == category }
  }
}
