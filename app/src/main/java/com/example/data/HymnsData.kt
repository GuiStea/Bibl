package com.example.data

import com.example.model.Hymn
import com.example.model.HymnCategory
import com.example.model.HymnVerse
import com.example.model.NoteTone

object HymnsData {

  // Frequencies for musical notes (Hz)
  private const val C4 = 261.63f
  private const val D4 = 293.66f
  private const val Eb4 = 311.13f
  private const val E4 = 329.63f
  private const val F4 = 349.23f
  private const val G4 = 392.00f
  private const val Ab4 = 415.30f
  private const val A4 = 440.00f
  private const val Bb4 = 466.16f
  private const val B4 = 493.88f
  private const val C5 = 523.25f
  private const val D5 = 587.33f
  private const val Eb5 = 622.25f
  private const val E5 = 659.25f
  private const val F5 = 698.46f
  private const val G5 = 783.99f

  private val melodyHymn1 = listOf(
    NoteTone(Eb4, 500), NoteTone(G4, 500), NoteTone(Bb4, 750), NoteTone(Bb4, 250),
    NoteTone(C5, 500), NoteTone(Bb4, 500), NoteTone(G4, 1000),
    NoteTone(Ab4, 500), NoteTone(G4, 500), NoteTone(F4, 750), NoteTone(Eb4, 250),
    NoteTone(F4, 1000), NoteTone(0f, 250, isRest = true),
    NoteTone(Eb4, 500), NoteTone(G4, 500), NoteTone(Bb4, 750), NoteTone(Bb4, 250),
    NoteTone(C5, 500), NoteTone(D5, 500), NoteTone(Eb5, 1000),
    NoteTone(D5, 500), NoteTone(C5, 500), NoteTone(Bb4, 500), NoteTone(G4, 500),
    NoteTone(F4, 750), NoteTone(Eb4, 1000)
  )

  private val melodyHymn23 = listOf(
    NoteTone(G4, 500), NoteTone(B4, 500), NoteTone(D5, 750), NoteTone(B4, 250),
    NoteTone(A4, 500), NoteTone(G4, 500), NoteTone(E4, 1000),
    NoteTone(G4, 500), NoteTone(A4, 500), NoteTone(B4, 750), NoteTone(D5, 250),
    NoteTone(A4, 1000), NoteTone(0f, 250, isRest = true),
    NoteTone(D5, 500), NoteTone(C5, 500), NoteTone(B4, 500), NoteTone(A4, 500),
    NoteTone(G4, 1000), NoteTone(E4, 500), NoteTone(D4, 500),
    NoteTone(G4, 750), NoteTone(A4, 250), NoteTone(G4, 1200)
  )

  private val melodyHymn36 = listOf(
    NoteTone(C4, 500), NoteTone(E4, 500), NoteTone(G4, 750), NoteTone(G4, 250),
    NoteTone(A4, 500), NoteTone(G4, 500), NoteTone(E4, 1000),
    NoteTone(F4, 500), NoteTone(E4, 500), NoteTone(D4, 750), NoteTone(E4, 250),
    NoteTone(C4, 1200)
  )

  private val melodyHymn131 = listOf(
    NoteTone(Bb4, 500), NoteTone(D5, 500), NoteTone(F5, 750), NoteTone(Eb5, 250),
    NoteTone(D5, 500), NoteTone(C5, 500), NoteTone(Bb4, 1000),
    NoteTone(C5, 500), NoteTone(D5, 500), NoteTone(Eb5, 500), NoteTone(D5, 500),
    NoteTone(C5, 1200)
  )

  val hymnsList: List<Hymn> = listOf(
    Hymn(
      number = 1,
      title = "Cristo, meu Mestre",
      tonality = "Mi bemol Maior",
      tempoBpm = 84,
      timeSignature = "4/4",
      category = HymnCategory.LOUVOR_E_ADORACAO,
      chorus = "Cristo, meu Mestre e meu Senhor, / Tua presença me dá vigor; / Pela fé sigo Tua instrução, / Para alcançar a salvação.",
      verses = listOf(
        HymnVerse(1, "Cristo, meu Mestre e meu Senhor, / Quero seguir-Te com fervor; / Em Tua graça vou confiar, / E Tua glória contemplar."),
        HymnVerse(2, "Em Teus preceitos quero andar, / E Tua voz sempre escutar; / Dá-me pureza e retidão, / Livra de toda tentação."),
        HymnVerse(3, "Breve nos céus eu Te verei, / Com Teus remidos cantarei; / Louvor eterno a Ti darei, / Ó meu bendito e santo Rei.")
      ),
      melodyNotes = melodyHymn1
    ),
    Hymn(
      number = 2,
      title = "De Deus tu és eleita",
      tonality = "Sol Maior",
      tempoBpm = 80,
      timeSignature = "3/4",
      category = HymnCategory.LOUVOR_E_ADORACAO,
      chorus = "Igreja valorosa, de Cristo mui amada, / Com glória e resplendor serás coroada.",
      verses = listOf(
        HymnVerse(1, "De Deus tu és eleita, igreja de Jesus, / Por Ele resgatada nas trevas para a luz; / Formosa aos Seus olhos, sem mancha e sem ruga, / No sangue do Cordeiro és pura e remida."),
        HymnVerse(2, "Conserva a tua veste na graça do Senhor, / Exalta a Sua obra com reverente amor; / Espera com paciência o Teu Esposo amado, / Pois breve reinarás no reino prometido.")
      ),
      melodyNotes = melodyHymn23
    ),
    Hymn(
      number = 5,
      title = "O supremo Criador",
      tonality = "Fá Maior",
      tempoBpm = 86,
      timeSignature = "4/4",
      category = HymnCategory.LOUVOR_E_ADORACAO,
      chorus = "Louvai a Deus, ó santos Seus! / Louvai a Deus, o Redentor! / Cantai com júbilo nos céus / As glórias do Criador!",
      verses = listOf(
        HymnVerse(1, "O supremo Criador, Deus de majestade e luz, / Revelou o Seu amor no bendito Rei Jesus; / Céus e terra hão de louvar a grandeza do Teu ser, / Pois eterno é Teu amor e supremo o Teu poder."),
        HymnVerse(2, "Pela Sua forte mão tudo fez subsistir, / Enche a terra de perdão para o homem redimir; / Tributemos honra e glória ao Cordeiro imaculado, / Que venceu e triunfou sobre a morte e o pecado.")
      ),
      melodyNotes = melodyHymn36
    ),
    Hymn(
      number = 15,
      title = "Ó alma que choras",
      tonality = "Lá bemol Maior",
      tempoBpm = 76,
      timeSignature = "6/8",
      category = HymnCategory.CONSOLACAO,
      chorus = "Ó alma que choras, confia em Deus, / Ele ouve o teu pranto lá dos altos céus; / Não há dor na terra que o Pai não console, / Ele é teu amparo e tua fortaleza.",
      verses = listOf(
        HymnVerse(1, "Ó alma que choras nas duras provações, / Derrama o teu pranto em santas orações; / O Mestre bondoso bem perto está de ti, / Dizendo com doçura: 'Descansa hoje em Mim'."),
        HymnVerse(2, "Se as ondas rugirem no mar da aflição, / Jesus segura firme na tua frágil mão; / A noite de tristeza em breve vai findar, / E o sol da esperança de novo vai brilhar.")
      ),
      melodyNotes = melodyHymn1
    ),
    Hymn(
      number = 23,
      title = "O Senhor é o meu Pastor",
      tonality = "Sol Maior",
      tempoBpm = 82,
      timeSignature = "4/4",
      category = HymnCategory.CONSOLACAO,
      chorus = "Nada me faltará, nada me faltará; / O Bom Pastor cuida de mim, / Em Seus braços me sustentará.",
      verses = listOf(
        HymnVerse(1, "O Senhor é o meu Pastor, nada me faltará; / Em pastos verdes e viçosos Ele me guiará; / Às águas mansas e tranquilas minha alma conduzirá, / E pelo caminho da retidão me sustentará."),
        HymnVerse(2, "Ainda que eu ande pelo vale da sombra da morte, / Não temerei mal algum, pois Tua presença é meu norte; / A Tua vara e o Teu cajado me consolam sem cessar, / E na Casa do meu Senhor para sempre vou habitar.")
      ),
      melodyNotes = melodyHymn23
    ),
    Hymn(
      number = 36,
      title = "A fiel proteção",
      tonality = "Dó Maior",
      tempoBpm = 84,
      timeSignature = "4/4",
      category = HymnCategory.CONSOLACAO,
      chorus = "Seguro estou nos braços de Deus, / Sob Suas asas encontro guarida; / O Pai celestial cuida bem dos que são Seus, / E dá-lhes a coroa da vida.",
      verses = listOf(
        HymnVerse(1, "A fiel proteção do divino Senhor / Nos guarda do perigo com infinito amor; / Nenhum mal atingirá a tenda do fiel, / Pois sobre nós vigia o Deus de Israel."),
        HymnVerse(2, "Pelos Seus santos anjos cercados nós seremos, / Em todas as pelejas vitória cantaremos; / Caminha com coragem, ó povo do Senhor, / Pois temos por escudo o grande Criador.")
      ),
      melodyNotes = melodyHymn36
    ),
    Hymn(
      number = 43,
      title = "Cinco letras preciosas",
      tonality = "Mi bemol Maior",
      tempoBpm = 88,
      timeSignature = "4/4",
      category = HymnCategory.LOUVOR_E_ADORACAO,
      chorus = "J-E-S-U-S, nome bendito! / J-E-S-U-S, doce e infinito! / Em Seu nome há perdão, cura e libertação, / É a fonte bendita da nossa salvação.",
      verses = listOf(
        HymnVerse(1, "Cinco letras preciosas formam um nome de poder, / Que consola os aflitos e faz a alma reviver; / Jesus Cristo é o Seu nome, o Cordeiro celestial, / Que nos deu na cruz o gozo da vitória triunfal."),
        HymnVerse(2, "Quando o crente pronuncia este nome em oração, / Os infernos estremecem e desce a comunhão; / Louvaremos eternamente o bendito Salvador, / Que nos ama com constante e sublime amor.")
      ),
      melodyNotes = melodyHymn1
    ),
    Hymn(
      number = 51,
      title = "Aos pés de Deus estamos",
      tonality = "Fá Maior",
      tempoBpm = 78,
      timeSignature = "4/4",
      category = HymnCategory.SUPLICACAO_E_ORACAO,
      chorus = "Atende, ó Deus, a nossa petição, / Dá-nos a paz e a consolação; / Derrama o Teu amor nos corações, / E ouve as nossas santas orações.",
      verses = listOf(
        HymnVerse(1, "Aos pés de Deus estamos em humilde oração, / Buscando Tua face em santa comunhão; / Perdoa nossas faltas por Teu imenso amor, / E dá-nos Tua graça, bendito Salvador."),
        HymnVerse(2, "Faz Tua santa voz em nós ressoar, / A fim de Teu conselho fielmente guardar; / Envia Teu poder, o Teu Consolador, / Para nos confortar com Teu calor.")
      ),
      melodyNotes = melodyHymn36
    ),
    Hymn(
      number = 76,
      title = "Cristo, Luz do mundo",
      tonality = "Sol Maior",
      tempoBpm = 84,
      timeSignature = "3/4",
      category = HymnCategory.LOUVOR_E_ADORACAO,
      chorus = "Cristo, Luz do mundo, resplandece em nós! / Guia nossos passos com Tua mansa voz; / Em Teu santo rastro sempre queremos ir, / Para no Teu reino Te contemplar e servir.",
      verses = listOf(
        HymnVerse(1, "Cristo, Luz do mundo, veio dissipar / As trevas do pecado e a paz restaurar; / Quem O segue fielmente jamais tropeçará, / Mas a luz da vida eterna sempre terá."),
        HymnVerse(2, "Sobre nós irradia Tua santa claridade, / Enche nossas almas de amor e de verdade; / Que sejamos tochas vivas neste mundo vil, / Proclamando as boas novas a um povo gentil.")
      ),
      melodyNotes = melodyHymn23
    ),
    Hymn(
      number = 104,
      title = "Santo! Santo! Santo!",
      tonality = "Mi bemol Maior",
      tempoBpm = 80,
      timeSignature = "4/4",
      category = HymnCategory.LOUVOR_E_ADORACAO,
      chorus = "Santo! Santo! Santo! Deus onipotente! / Todas as Tuas obras Te louvam no universo; / Santo! Santo! Santo! Justo e clemente, / És Deus triunfante em santo amor imerso.",
      verses = listOf(
        HymnVerse(1, "Santo! Santo! Santo! Senhor Deus onipotente! / Cedo de manhã cantaremos Teu louvor; / Santo! Santo! Santo! Justo e compassivo, / Deus glorioso, nosso Criador."),
        HymnVerse(2, "Santo! Santo! Santo! Os remidos Te adoram, / Lançando suas coroas no mar de cristal; / Serafins e anjos reverentes clamam: / Digno és de honra e glória celestial.")
      ),
      melodyNotes = melodyHymn1
    ),
    Hymn(
      number = 131,
      title = "Ó Senhor bendito",
      tonality = "Si bemol Maior",
      tempoBpm = 82,
      timeSignature = "4/4",
      category = HymnCategory.SUPLICACAO_E_ORACAO,
      chorus = "Vem, Jesus bendito, reina em meu ser; / Faz a Tua graça em mim florescer; / Quero consagrar-me todo ao Teu louvor, / Para ser guiado por Teu grande amor.",
      verses = listOf(
        HymnVerse(1, "Ó Senhor bendito, venho a Ti suplicar, / Limpa o meu coração para Te adorar; / Dá-me sabedoria para Te bem servir, / E a Tua santa lei sempre cumprir."),
        HymnVerse(2, "Em Tua comunhão encontro doce paz, / O Teu poder divino tudo em mim refaz; / Guarda a minha vida no Teu bom caminho, / Para que eu jamais me sinta sozinho.")
      ),
      melodyNotes = melodyHymn131
    ),
    Hymn(
      number = 147,
      title = "É bom louvar ao Criador",
      tonality = "Fá Maior",
      tempoBpm = 86,
      timeSignature = "4/4",
      category = HymnCategory.LOUVOR_E_ADORACAO,
      chorus = "Cantai, cantai, com alegria e fervor! / Louvai, louvai, ao Deus de imenso amor! / Proclamai Suas virtudes por todo o lugar, / Pois grandioso é Seu poder sem par.",
      verses = listOf(
        HymnVerse(1, "É bom louvar ao Criador com toda a devoção, / Cantar salmos de glória de puro coração; / Anunciar de manhã a Tua benignidade, / E de noite a Tua fidelidade."),
        HymnVerse(2, "Com harpas e alaúdes Teu nome exaltarei, / Pelas Tuas grandes obras jubilarei; / Quão profundos são os Teus pensamentos, Senhor, / Exaltado sejas, eterno Protetor.")
      ),
      melodyNotes = melodyHymn36
    ),
    Hymn(
      number = 193,
      title = "Vou orar ao Pai celeste",
      tonality = "Dó Maior",
      tempoBpm = 80,
      timeSignature = "4/4",
      category = HymnCategory.SUPLICACAO_E_ORACAO,
      chorus = "Orar, orar ao Pai em nome de Jesus, / Receber virtude e celestial luz; / Na oração secreta encontro salvação, / E a doce resposta para o coração.",
      verses = listOf(
        HymnVerse(1, "Vou orar ao Pai celeste em humilde submissão, / Entregar em Suas mãos toda a minha aflição; / Ele é fiel amigo, pronto a me atender, / Nele tenho vida, graça e poder."),
        HymnVerse(2, "Mesmo quando as lágrimas turvarem meu olhar, / Sei que o Salvador virá me consolar; / Não há tempestade que não vá cessar, / Quando o crente aprende em silêncio orar.")
      ),
      melodyNotes = melodyHymn36
    ),
    Hymn(
      number = 207,
      title = "Cristo é meu amigo fiel",
      tonality = "Fá Maior",
      tempoBpm = 84,
      timeSignature = "4/4",
      category = HymnCategory.CONSOLACAO,
      chorus = "Amigo fiel, Amigo sem igual! / Guarda a minha vida de todo o mal; / Em Seus santos passos sempre vou andar, / Até que na glória eu possa descansar.",
      verses = listOf(
        HymnVerse(1, "Cristo é meu amigo fiel em toda a aflição, / Nunca me despreza nem larga a minha mão; / Quando o mundo falha e a solidão me vem, / Cristo Se achega e me faz tão bem."),
        HymnVerse(2, "Seu conselho é vida, Sua voz é paz, / Tudo quanto Ele promete fielmente faz; / Ó quão preciosa é Sua santa luz, / Quero estar bem junto do meu bom Jesus.")
      ),
      melodyNotes = melodyHymn36
    ),
    Hymn(
      number = 232,
      title = "Seguirei a Cristo",
      tonality = "Fá Maior",
      tempoBpm = 82,
      timeSignature = "4/4",
      category = HymnCategory.LOUVOR_E_ADORACAO,
      chorus = "Seguirei, seguirei a Cristo onde for! / Guiado pela luz do Seu imenso amor; / Nem perigo, nem dor me poderá deter, / Pois com meu Salvador hei de vencer.",
      verses = listOf(
        HymnVerse(1, "Seguirei a Cristo com fervor e amor, / Ele é meu Pastor e eterno Protetor; / Pelas veredas santas quero caminhar, / E o Seu testemunho fiel proclamar."),
        HymnVerse(2, "Tome a sua cruz quem quer após Si vir, / E os santos mandamentos procure cumprir; / A recompensa é grande no reino da luz, / Para o servo fiel que segue a Jesus.")
      ),
      melodyNotes = melodyHymn36
    ),
    Hymn(
      number = 235,
      title = "Já se aproxima a redenção",
      tonality = "Mi bemol Maior",
      tempoBpm = 88,
      timeSignature = "4/4",
      category = HymnCategory.CONSOLACAO,
      chorus = "Ora vem, Senhor Jesus! / Vem buscar Teu povo à luz! / Cessará todo o pranto e dor, / Nos braços do Redentor.",
      verses = listOf(
        HymnVerse(1, "Já se aproxima a redenção da igreja do Senhor, / Ergamos nossas frontes com júbilo e fervor; / Os sinais nos mostram que o fim está a chegar, / E o Noivo celestial breve há de voltar."),
        HymnVerse(2, "Conserva a tua lâmpada acesa com azeite santo, / Em breve cessará toda a aflição e pranto; / As bodas do Cordeiro estão preparadas já, / E com vestes puras a noiva entrará.")
      ),
      melodyNotes = melodyHymn1
    ),
    Hymn(
      number = 248,
      title = "Glória, aleluia! Sinto o Senhor",
      tonality = "Sol Maior",
      tempoBpm = 90,
      timeSignature = "4/4",
      category = HymnCategory.LOUVOR_E_ADORACAO,
      chorus = "Glória, aleluia! Sinto o Senhor! / Enchendo o meu peito de paz e fervor; / Não há outro Deus tão sublime e sem par, / Só a Ele pertence o meu adorar.",
      verses = listOf(
        HymnVerse(1, "Glória, aleluia! Sinto o Senhor no meio da congregação, / Operando maravilhas e dando salvação; / O Seu Santo Espírito se move com poder, / Fazendo a alegria da fé renascer."),
        HymnVerse(2, "Louvemos o Seu Nome com santa gratidão, / Pelo sangue precioso da nossa redenção; / Hosana nas alturas ao Rei triunfal, / Que nos prometeu a herança celestial.")
      ),
      melodyNotes = melodyHymn23
    ),
    Hymn(
      number = 260,
      title = "Sou servo inútil, ó Deus",
      tonality = "Dó Menor",
      tempoBpm = 72,
      timeSignature = "3/4",
      category = HymnCategory.SUPLICACAO_E_ORACAO,
      chorus = "Nada sou, meu Senhor, sem Tua graça e amor; / Mas em Ti sou mais que vencedor; / Faz de mim um vaso para Teu louvor, / Conduzido pelo Teu Consolador.",
      verses = listOf(
        HymnVerse(1, "Sou servo inútil, ó Deus, humilho-me a Teus pés, / Reconheço que és Santo e justo como és; / Se fiz algo de bom foi por Tua compaixão, / Que operou em mim a regeneração."),
        HymnVerse(2, "Dá-me espírito reto e coração contrito, / Livra-me do orgulho e do mundo maldito; / Quero ser pequeno para que possas crescer, / E na minha fraqueza Teu poder resplandecer.")
      ),
      melodyNotes = melodyHymn1
    ),
    Hymn(
      number = 300,
      title = "Lembrar-me-ei de Ti",
      tonality = "Si bemol Maior",
      tempoBpm = 76,
      timeSignature = "4/4",
      category = HymnCategory.SANTA_CEIA,
      chorus = "Lembrar-me-ei de Ti, ó Salvador Jesus! / Do Teu grande martírio na amarga cruz; / Do cálice de amor e do pão partido, / Por onde o pecador foi redimido.",
      verses = listOf(
        HymnVerse(1, "Lembrar-me-ei de Ti, Jesus, meu Benfeitor, / Que deste Tua vida por mim em Teu amor; / No cálice e no pão da Santa Comunhão, / Relembro Teu sacrifício de salvação."),
        HymnVerse(2, "O Teu corpo ferido nos trouxe a união, / O Teu sangue vertido nos deu o perdão; / Com reverência santa comemos deste pão, / Até que Tu venhas na consumação.")
      ),
      melodyNotes = melodyHymn131
    ),
    Hymn(
      number = 400,
      title = "Ó formoso céu!",
      tonality = "Fá Maior",
      tempoBpm = 86,
      timeSignature = "4/4",
      category = HymnCategory.LOUVOR_E_ADORACAO,
      chorus = "Ó formoso céu, pátria de esplendor! / Onde habitarei com o meu Salvador; / Ruas todas de ouro, rios de cristal, / Onde cantarei o hino triunfal.",
      verses = listOf(
        HymnVerse(1, "Ó formoso céu, morada de amor, / Onde não há noite, nem tristeza ou dor; / Deus enxugará dos olhos todo o pranto, / E reinaremos com o Cordeiro santo."),
        HymnVerse(2, "Para lá caminham os servos do Senhor, / Revestidos da graça do Consolador; / Breve romperão as nuvens celestiais, / E nos uniremos aos coros angelicais.")
      ),
      melodyNotes = melodyHymn36
    ),
    Hymn(
      number = 433,
      title = "Jovens, amai o Conselho divino",
      tonality = "Fá Maior",
      tempoBpm = 86,
      timeSignature = "4/4",
      category = HymnCategory.JOVENS_E_MENORES,
      chorus = "Jovens amados, segui a Jesus! / Fugi do engano, andai na Sua luz; / A mocidade consagrada ao Criador / É como um jardim florido em louvor.",
      verses = listOf(
        HymnVerse(1, "Jovens, amai o Conselho divino da santa Palavra de Deus, / Guardai no coração o sagrado ensino que guia com segurança aos céus; / Não sigais as vaidades passageiras deste mundo de ilusão, / Mas buscai as riquezas verdadeiras da celeste salvação."),
        HymnVerse(2, "Sede prudentes, guardando a pureza em meio às fortes tentações, / O Senhor recompensará com certeza a fidelidade dos corações; / Com alegria louvai ao Senhor na aurora da vossa idade, / E tereis a vitória do Consolador por toda a eternidade.")
      ),
      melodyNotes = melodyHymn36
    ),
    Hymn(
      number = 454,
      title = "Cidadãos dos céus",
      tonality = "Dó Maior",
      tempoBpm = 88,
      timeSignature = "4/4",
      category = HymnCategory.JOVENS_E_MENORES,
      chorus = "Cidadãos dos céus nós somos pela fé, / Nosso Rei e Guia Jesus Cristo é; / Pequenos soldados de grande valor, / Marchando triunfantes com o Salvador.",
      verses = listOf(
        HymnVerse(1, "Cidadãos dos céus nós somos pela fé em Jesus, / Caminhando alegres pelo caminho da luz; / Mesmo sendo pequeninos podemos cantar / E o amor de Deus aos outros ensinar."),
        HymnVerse(2, "Jesus ama as crianças e as guarda do mal, / Concedendo a bênção da vida eternal; / Vamos sempre obedecer a nossos pais e ao Senhor, / E viver unidos em santo amor.")
      ),
      melodyNotes = melodyHymn36
    )
  )

  fun searchHymns(query: String, category: HymnCategory = HymnCategory.TODOS): List<Hymn> {
    val cleanQuery = query.trim().lowercase()
    return hymnsList.filter { hymn ->
      val matchesCategory = (category == HymnCategory.TODOS || hymn.category == category)
      val matchesQuery = if (cleanQuery.isEmpty()) {
        true
      } else {
        hymn.number.toString().contains(cleanQuery) ||
        hymn.title.lowercase().contains(cleanQuery) ||
        hymn.verses.any { it.text.lowercase().contains(cleanQuery) } ||
        (hymn.chorus?.lowercase()?.contains(cleanQuery) == true)
      }
      matchesCategory && matchesQuery
    }
  }

  fun getHymnByNumber(number: Int): Hymn? {
    return hymnsList.find { it.number == number }
  }
}
