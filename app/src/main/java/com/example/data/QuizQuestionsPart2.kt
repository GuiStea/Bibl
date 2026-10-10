package com.example.data

import com.example.model.QuizCategory
import com.example.model.QuizDifficulty
import com.example.model.QuizQuestion

object QuizQuestionsPart2 {
  val questions: List<QuizQuestion> = listOf(
    QuizQuestion(
      id = 101,
      question = "Qual profeta foi alimentado por corvos junto ao ribeiro de Querite?",
      options = listOf("Ezequiel", "Elias", "Eliseu", "Amós"),
      correctOptionIndex = 1,
      biblicalReference = "1 Reis 17:4-6",
      explanation = "Os corvos traziam a Elias pão e carne pela manhã e pela tarde.",
      difficulty = QuizDifficulty.FACIL,
      category = QuizCategory.PROFETAS
    ),
    QuizQuestion(
      id = 102,
      question = "Quem foi transformado em estátua de sal por olhar para trás na destruição de Sodoma?",
      options = listOf("A esposa de Noé", "A mulher de Ló", "A filha de Labão", "A serva Agar"),
      correctOptionIndex = 1,
      biblicalReference = "Gênesis 19:26",
      explanation = "A mulher de Ló olhou para trás, desafiando a ordem angelical, e converteu-se numa estátua de sal.",
      difficulty = QuizDifficulty.FACIL,
      category = QuizCategory.PERSONAGENS
    ),
    QuizQuestion(
      id = 103,
      question = "Qual jovem pastor hebreu tocava harpa para acalmar o espírito perturbado do rei Saul?",
      options = listOf("Salomão", "Davi", "Abinadabe", "Asafe"),
      correctOptionIndex = 1,
      biblicalReference = "1 Samuel 16:23",
      explanation = "Quando Davi tangia a harpa com sua mão, Saul sentia alívio e achava-se melhor.",
      difficulty = QuizDifficulty.FACIL,
      category = QuizCategory.PERSONAGENS
    ),
    QuizQuestion(
      id = 104,
      question = "Quantos livros compõem o Novo Testamento no cânon cristão tradicional?",
      options = listOf("24", "27", "39", "66"),
      correctOptionIndex = 1,
      biblicalReference = "Cânon Bíblico",
      explanation = "O Novo Testamento possui 27 livros e o Antigo Testamento possui 39 livros, totalizando 66 livros.",
      difficulty = QuizDifficulty.FACIL,
      category = QuizCategory.NOVO_TESTAMENTO
    ),
    QuizQuestion(
      id = 105,
      question = "Qual rei de Judá começou a reinar com apenas 8 anos de idade e promoveu grande reforma espiritual?",
      options = listOf("Josias", "Manassés", "Roboão", "Joás"),
      correctOptionIndex = 0,
      biblicalReference = "2 Reis 22:1",
      explanation = "Josias tinha oito anos quando começou a reinar e fez o que era reto aos olhos do Senhor.",
      difficulty = QuizDifficulty.MEDIO,
      category = QuizCategory.PROFETAS
    ),
    QuizQuestion(
      id = 106,
      question = "Em qual cidade os discípulos foram chamados 'cristãos' pela primeira vez?",
      options = listOf("Jerusalém", "Antioquia", "Roma", "Éfeso"),
      correctOptionIndex = 1,
      biblicalReference = "Atos 11:26",
      explanation = "Em Antioquia foram os discípulos, pela primeira vez, chamados cristãos.",
      difficulty = QuizDifficulty.MEDIO,
      category = QuizCategory.NOVO_TESTAMENTO
    ),
    QuizQuestion(
      id = 107,
      question = "Quem orou pedindo que o sol e a lua se detivessem no vale de Aijalom durante a batalha?",
      options = listOf("Moisés", "Josué", "Gideão", "Sansão"),
      correctOptionIndex = 1,
      biblicalReference = "Josué 10:12-13",
      explanation = "O sol se deteve e a lua parou até que o povo se vingou de seus inimigos sob Josué.",
      difficulty = QuizDifficulty.FACIL,
      category = QuizCategory.MILAGRES_E_PARABOLAS
    ),
    QuizQuestion(
      id = 108,
      question = "Qual o nome da vendedora de púrpura que se converteu e hospedou Paulo e Silas em Filipos?",
      options = listOf("Priscila", "Lídia", "Febe", "Eunice"),
      correctOptionIndex = 1,
      biblicalReference = "Atos 16:14-15",
      explanation = "O Senhor abriu o coração de Lídia, da cidade de Tiatira, para atender às coisas que Paulo dizia.",
      difficulty = QuizDifficulty.MEDIO,
      category = QuizCategory.PERSONAGENS
    ),
    QuizQuestion(
      id = 109,
      question = "Quem fez flutuar o machado de ferro caído na água das correntes do Jordão?",
      options = listOf("Elias", "Eliseu", "Josué", "Gideão"),
      correctOptionIndex = 1,
      biblicalReference = "2 Reis 6:5-6",
      explanation = "O homem de Deus Eliseu cortou um pau, lançou-o ali e fez flutuar o ferro.",
      difficulty = QuizDifficulty.MEDIO,
      category = QuizCategory.MILAGRES_E_PARABOLAS
    ),
    QuizQuestion(
      id = 110,
      question = "Qual apóstolo era irmão de Simão Pedro e também pescador?",
      options = listOf("Tiago", "João", "André", "Filipe"),
      correctOptionIndex = 2,
      biblicalReference = "Mateus 4:18",
      explanation = "André encontrou primeiro o Messias e levou seu irmão Simão Pedro até Jesus.",
      difficulty = QuizDifficulty.FACIL,
      category = QuizCategory.EVANGELHOS
    ),
    QuizQuestion(
      id = 111,
      question = "Qual o nome da montanha onde a arca de Noé repousou após as águas do dilúvio baixarem?",
      options = listOf("Montes de Ararate", "Monte Sinai", "Monte Moriá", "Monte Nebo"),
      correctOptionIndex = 0,
      biblicalReference = "Gênesis 8:4",
      explanation = "A arca repousou no sétimo mês, no dia dezessete do mês, sobre os montes de Ararate.",
      difficulty = QuizDifficulty.FACIL,
      category = QuizCategory.ANTIGO_TESTAMENTO
    ),
    QuizQuestion(
      id = 112,
      question = "Qual o nome do marido de Maria e pai terreno adotivo de Jesus?",
      options = listOf("Zacarias", "José", "Joaquim", "Simeão"),
      correctOptionIndex = 1,
      biblicalReference = "Mateus 1:16-19",
      explanation = "José, carpinteiro da linhagem de Davi, homem justo e obediente às ordens do anjo.",
      difficulty = QuizDifficulty.FACIL,
      category = QuizCategory.EVANGELHOS
    ),
    QuizQuestion(
      id = 113,
      question = "Quem foi o idoso profeta no Templo que tomou o menino Jesus nos braços e louvou a Deus?",
      options = listOf("Nicodemos", "Simeão", "Gamaliel", "Zacarias"),
      correctOptionIndex = 1,
      biblicalReference = "Lucas 2:25-32",
      explanation = "Simeão exclamou: 'Agora despedes em paz o teu servo, pois os meus olhos viram a tua salvação'.",
      difficulty = QuizDifficulty.MEDIO,
      category = QuizCategory.EVANGELHOS
    ),
    QuizQuestion(
      id = 114,
      question = "Quantas vezes devemos perdoar nosso irmão, segundo a resposta de Jesus a Pedro em Mateus 18?",
      options = listOf("Até 7 vezes", "Até 10 vezes", "Até 70 vezes 7", "Uma vez apenas"),
      correctOptionIndex = 2,
      biblicalReference = "Mateus 18:21-22",
      explanation = "Jesus disse: 'Não te digo que até sete vezes, mas até setenta vezes sete'.",
      difficulty = QuizDifficulty.FACIL,
      category = QuizCategory.EVANGELHOS
    ),
    QuizQuestion(
      id = 115,
      question = "Quem teve um encontro noturno com Jesus e ouviu sobre a necessidade de 'nascer de novo'?",
      options = listOf("Nicodemos", "Zaqueu", "Caifás", "Bartimeu"),
      correctOptionIndex = 0,
      biblicalReference = "João 3:1-3",
      explanation = "Nicodemos, príncipe dos judeus e mestre da lei, veio a Jesus de noite.",
      difficulty = QuizDifficulty.FACIL,
      category = QuizCategory.EVANGELHOS
    ),
    QuizQuestion(
      id = 116,
      question = "Qual foi o nome do lugar onde Jesus foi crucificado (que significa 'Lugar da Caveira')?",
      options = listOf("Getsêmani", "Gólgota (Calvário)", "Betânia", "Sicar"),
      correctOptionIndex = 1,
      biblicalReference = "Mateus 27:33; Lucas 23:33",
      explanation = "Chegando a um lugar chamado Gólgota, que quer dizer Lugar da Caveira, o crucificaram.",
      difficulty = QuizDifficulty.FACIL,
      category = QuizCategory.EVANGELHOS
    ),
    QuizQuestion(
      id = 117,
      question = "Quem cedeu seu próprio sepulcro novo cavado na rocha para o sepultamento de Jesus?",
      options = listOf("Lázaro", "José de Arimateia", "Nicodemos", "Simão Cireneu"),
      correctOptionIndex = 1,
      biblicalReference = "Mateus 27:57-60",
      explanation = "José de Arimateia, homem nobre e rico discípulo de Jesus, pediu o corpo e colocou-O em seu sepulcro novo.",
      difficulty = QuizDifficulty.FACIL,
      category = QuizCategory.EVANGELHOS
    ),
    QuizQuestion(
      id = 118,
      question = "Quem foi constrangido pelos soldados romanos a carregar a cruz de Jesus?",
      options = listOf("Simão, o cireneu", "Barrabás", "João", "José de Arimateia"),
      correctOptionIndex = 0,
      biblicalReference = "Marcos 15:21",
      explanation = "Constrangeram um certo Simão de Cirene, que vinha do campo, a levar a sua cruz.",
      difficulty = QuizDifficulty.FACIL,
      category = QuizCategory.EVANGELHOS
    ),
    QuizQuestion(
      id = 119,
      question = "Quantos dias após a ressurreição Jesus ascendeu aos céus diante dos apóstolos?",
      options = listOf("7 dias", "14 dias", "40 dias", "50 dias"),
      correctOptionIndex = 2,
      biblicalReference = "Atos 1:3",
      explanation = "Aos quais também se apresentou vivo, com muitas e infalíveis provas, sendo visto por eles por espaço de quarenta dias.",
      difficulty = QuizDifficulty.MEDIO,
      category = QuizCategory.NOVO_TESTAMENTO
    ),
    QuizQuestion(
      id = 120,
      question = "Quem escreveu o livro bíblico de Provérbios em sua maior parte?",
      options = listOf("Davi", "Salomão", "Ezequias", "Agur"),
      correctOptionIndex = 1,
      biblicalReference = "Provérbios 1:1",
      explanation = "Os provérbios de Salomão, filho de Davi, rei de Israel, cheios de sábios ensinamentos morais.",
      difficulty = QuizDifficulty.FACIL,
      category = QuizCategory.ANTIGO_TESTAMENTO
    ),
    QuizQuestion(
      id = 121,
      question = "Qual profeta foi casado com Gômer como representação da infidelidade de Israel e do amor perdoador de Deus?",
      options = listOf("Joel", "Amós", "Oséias", "Malaquias"),
      correctOptionIndex = 2,
      biblicalReference = "Oséias 1:2-3",
      explanation = "O ministério de Oséias ilustrou de modo comovente o pacto de aliança e perdão de Deus para com Seu povo.",
      difficulty = QuizDifficulty.MEDIO,
      category = QuizCategory.PROFETAS
    ),
    QuizQuestion(
      id = 122,
      question = "Qual profeta declarou: 'Ainda que a figueira não floresça... todavia eu me alegrarei no Senhor'?",
      options = listOf("Habacuque", "Zacarias", "Naum", "Sofonias"),
      correctOptionIndex = 0,
      biblicalReference = "Habacuque 3:17-18",
      explanation = "Habacuque expressa o triunfo incondicional da fé e alegria no Deus da salvação.",
      difficulty = QuizDifficulty.FACIL,
      category = QuizCategory.PROFETAS
    ),
    QuizQuestion(
      id = 123,
      question = "Quem foi o companheiro fiel de Josué que também trouxe relatório de fé e herdou o monte Hebrom aos 85 anos?",
      options = listOf("Otniel", "Calebe", "Hur", "Finéias"),
      correctOptionIndex = 1,
      biblicalReference = "Josué 14:10-14",
      explanation = "Calebe, filho de Jefoné, perseverou em seguir ao Senhor Deus de Israel e conservou vigor extraordinário.",
      difficulty = QuizDifficulty.FACIL,
      category = QuizCategory.PERSONAGENS
    ),
    QuizQuestion(
      id = 124,
      question = "Quantos filhos e filhas Jó tinha antes do primeiro dia de provação?",
      options = listOf("3 filhos e 3 filhas", "7 filhos e 3 filhas (10 no total)", "12 filhos", "5 filhos e 5 filhas"),
      correctOptionIndex = 1,
      biblicalReference = "Jó 1:2",
      explanation = "Nasceram-lhe sete filhos e três filhas, e no fim de sua vida Deus restaurou-lhe o dobro dos bens e outros 10 filhos.",
      difficulty = QuizDifficulty.MEDIO,
      category = QuizCategory.ANTIGO_TESTAMENTO
    ),
    QuizQuestion(
      id = 125,
      question = "Qual profetisa liderou os cânticos com tamboris após o povo de Israel atravessar o Mar Vermelho?",
      options = listOf("Débora", "Miriã", "Hulda", "Ana"),
      correctOptionIndex = 1,
      biblicalReference = "Êxodo 15:20-21",
      explanation = "Miriã, irmã de Moisés e Arão, tomou o tamboril e cantou: 'Cantai ao Senhor, porque gloriosamente triunfou'.",
      difficulty = QuizDifficulty.FACIL,
      category = QuizCategory.PERSONAGENS
    ),
    QuizQuestion(
      id = 126,
      question = "Qual era a cidade natal do apóstolo Paulo?",
      options = listOf("Tarso da Cilícia", "Damasco", "Antioquia", "Jerusalém"),
      correctOptionIndex = 0,
      biblicalReference = "Atos 22:3",
      explanation = "Paulo declarou: 'Sou judeu, nascido em Tarso da Cilícia, e nesta cidade criado aos pés de Gamaliel'.",
      difficulty = QuizDifficulty.FACIL,
      category = QuizCategory.NOVO_TESTAMENTO
    ),
    QuizQuestion(
      id = 127,
      question = "Quem era o governador romano da Judeia perante o qual Paulo fez sua defesa em Atos 24?",
      options = listOf("Pôncio Pilatos", "Félix", "Gálio", "César Augusto"),
      correctOptionIndex = 1,
      biblicalReference = "Atos 24:1-24",
      explanation = "O governador Félix ouviu Paulo discorrer sobre a justiça, a temperança e o juízo vindouro.",
      difficulty = QuizDifficulty.DIFICIL,
      category = QuizCategory.NOVO_TESTAMENTO
    ),
    QuizQuestion(
      id = 128,
      question = "Qual jovem pastor e cooperador recebeu duas cartas pastorais de Paulo com instruções para a igreja?",
      options = listOf("Tito", "Timóteo", "Filemom", "Lucas"),
      correctOptionIndex = 1,
      biblicalReference = "1 Timóteo 1:1-2",
      explanation = "Timóteo foi chamado por Paulo de 'meu verdadeiro filho na fé'.",
      difficulty = QuizDifficulty.FACIL,
      category = QuizCategory.NOVO_TESTAMENTO
    ),
    QuizQuestion(
      id = 129,
      question = "Qual o nome da mãe e da avó piedosas de Timóteo elogiadas por Paulo por sua fé não fingida?",
      options = listOf("Sara e Rebeca", "Eunice e Lóide", "Marta e Maria", "Priscila e Cláudia"),
      correctOptionIndex = 1,
      biblicalReference = "2 Timóteo 1:5",
      explanation = "Paulo lembrou da fé que habitou primeiro em sua avó Lóide e em sua mãe Eunice.",
      difficulty = QuizDifficulty.MEDIO,
      category = QuizCategory.NOVO_TESTAMENTO
    ),
    QuizQuestion(
      id = 130,
      question = "Qual escravo fugitivo tornou-se irmão em Cristo sob o ministério de Paulo e deu origem à carta a Filemom?",
      options = listOf("Onésimo", "Tíquico", "Erasto", "Epafrodito"),
      correctOptionIndex = 0,
      biblicalReference = "Filemom 1:10",
      explanation = "Paulo roga por Onésimo, que gerou na prisão, agora útil e amado irmão.",
      difficulty = QuizDifficulty.MEDIO,
      category = QuizCategory.NOVO_TESTAMENTO
    ),
    QuizQuestion(
      id = 131,
      question = "O que Jesus usou para curar os olhos do cego de nascença em João 9?",
      options = listOf("Água pura", "Lodo feito com saliva, mandando lavar no tanque de Siloé", "Azeite ungido", "Folhas de oliveira"),
      correctOptionIndex = 1,
      biblicalReference = "João 9:6-7",
      explanation = "Cuspindo na terra, fez lodo com a saliva e untou os olhos do cego, mandando-o lavar em Siloé.",
      difficulty = QuizDifficulty.MEDIO,
      category = QuizCategory.MILAGRES_E_PARABOLAS
    ),
    QuizQuestion(
      id = 132,
      question = "Qual o nome da piscina em Jerusalém que tinha cinco alpendres e onde um paralítico esperava há 38 anos?",
      options = listOf("Siloé", "Betesda", "Gibeom", "En-Rogel"),
      correctOptionIndex = 1,
      biblicalReference = "João 5:2-5",
      explanation = "No tanque de Betesda, Jesus disse ao homem: 'Levanta-te, toma a tua cama e anda'.",
      difficulty = QuizDifficulty.MEDIO,
      category = QuizCategory.MILAGRES_E_PARABOLAS
    ),
    QuizQuestion(
      id = 133,
      question = "Quantos leprosos foram curados por Jesus ao mesmo tempo e quantos voltaram para agradecer?",
      options = listOf("10 foram curados e 5 voltaram", "10 foram curados e apenas 1 voltou", "7 foram curados e todos voltaram", "12 foram curados e nenhum voltou"),
      correctOptionIndex = 1,
      biblicalReference = "Lucas 17:12-18",
      explanation = "Dez foram limpos, mas apenas um samaritano voltou dando glória a Deus em alta voz.",
      difficulty = QuizDifficulty.FACIL,
      category = QuizCategory.MILAGRES_E_PARABOLAS
    ),
    QuizQuestion(
      id = 134,
      question = "Qual o nome do cego de Jericó que clamou insistentemente: 'Jesus, Filho de Davi, tem misericórdia de mim!'?",
      options = listOf("Simão", "Bartimeu", "Malaquias", "Eleazar"),
      correctOptionIndex = 1,
      biblicalReference = "Marcos 10:46-52",
      explanation = "Bartimeu, filho de Timeu, lançou de si a capa e correu até Jesus, recebendo a visão.",
      difficulty = QuizDifficulty.FACIL,
      category = QuizCategory.MILAGRES_E_PARABOLAS
    ),
    QuizQuestion(
      id = 135,
      question = "Qual das parábolas ilustra a alegria nos céus pelo arrependimento de um pecador?",
      options = listOf("A parábola do grão de mostarda", "A ovelha perdida e a dracma perdida", "O fermento na massa", "Os dois alicerces"),
      correctOptionIndex = 1,
      biblicalReference = "Lucas 15:7-10",
      explanation = "Há júbilo diante dos anjos de Deus por um pecador que se arrepende.",
      difficulty = QuizDifficulty.FACIL,
      category = QuizCategory.MILAGRES_E_PARABOLAS
    ),
    QuizQuestion(
      id = 136,
      question = "Qual era o nome do sumo sacerdote que presidiu o julgamento judaico perante o Sinédrio na noite em que Jesus foi preso?",
      options = listOf("Anás", "Caifás", "Gamaliel", "Nicodemos"),
      correctOptionIndex = 1,
      biblicalReference = "Mateus 26:57",
      explanation = "Jesus foi levado à casa de Caifás, onde os escribas e anciãos estavam reunidos.",
      difficulty = QuizDifficulty.MEDIO,
      category = QuizCategory.EVANGELHOS
    ),
    QuizQuestion(
      id = 137,
      question = "Qual apóstolo substituiu Pedro no discurso de liderança em Jerusalém em Atos 15?",
      options = listOf("Tiago, irmão do Senhor", "João", "Filipe", "Tomé"),
      correctOptionIndex = 0,
      biblicalReference = "Atos 15:13-19",
      explanation = "Tiago, que liderava a igreja em Jerusalém, deu o parecer conciliatório sobre os gentios convertidos.",
      difficulty = QuizDifficulty.DIFICIL,
      category = QuizCategory.NOVO_TESTAMENTO
    ),
    QuizQuestion(
      id = 138,
      question = "Qual discípula de Jope fazia túnicas e vestidos para os pobres e foi ressuscitada por Pedro?",
      options = listOf("Dorcas (Tabita)", "Lídia", "Febe", "Priscila"),
      correctOptionIndex = 0,
      biblicalReference = "Atos 9:36-40",
      explanation = "Tabita (Dorcas) era cheia de boas obras e esmolas, e Pedro orou e ela abriu os olhos.",
      difficulty = QuizDifficulty.MEDIO,
      category = QuizCategory.PERSONAGENS
    ),
    QuizQuestion(
      id = 139,
      question = "Quem batizou o eunuco etíope no caminho deserto que desce de Jerusalém a Gaza?",
      options = listOf("Estêvão", "Filipe o evangelista", "Pedro", "Paulo"),
      correctOptionIndex = 1,
      biblicalReference = "Atos 8:26-38",
      explanation = "O Espírito enviou o diácono Filipe, que lhe anunciou a Cristo a partir do texto de Isaías 53.",
      difficulty = QuizDifficulty.FACIL,
      category = QuizCategory.NOVO_TESTAMENTO
    ),
    QuizQuestion(
      id = 140,
      question = "Qual rei da Babilônia enlouqueceu e viveu com os animais do campo por sete tempos até reconhecer a soberania de Deus?",
      options = listOf("Belsazar", "Nabucodonosor", "Dario", "Ciro"),
      correctOptionIndex = 1,
      biblicalReference = "Daniel 4:32-34",
      explanation = "Nabucodonosor foi expulso do meio dos homens até reconhecer que o Altíssimo reina sobre os reinos.",
      difficulty = QuizDifficulty.MEDIO,
      category = QuizCategory.PROFETAS
    ),
    QuizQuestion(
      id = 141,
      question = "O que apareceu na parede do palácio durante o banquete profano do rei Belsazar?",
      options = listOf("Uma tocha de fogo", "Dedos de mão de homem escrevendo: Mene, Mene, Tequel, Ufarsim", "Um relâmpago estrondoso", "A sombra de uma coruja"),
      correctOptionIndex = 1,
      biblicalReference = "Daniel 5:5-25",
      explanation = "Daniel interpretou que o reino de Belsazar fora contado, pesado na balança e dividido.",
      difficulty = QuizDifficulty.MEDIO,
      category = QuizCategory.PROFETAS
    ),
    QuizQuestion(
      id = 142,
      question = "Quem deu o famoso conselho aos líderes do Sinédrio: 'Se esta obra for de homens, se desfará; mas se for de Deus, não podereis derrotá-la'?",
      options = listOf("Nicodemos", "Gamaliel", "José de Arimateia", "Caifás"),
      correctOptionIndex = 1,
      biblicalReference = "Atos 5:34-39",
      explanation = "O sábio doutor da lei Gamaliel persuadiu o conselho a não matar os apóstolos.",
      difficulty = QuizDifficulty.MEDIO,
      category = QuizCategory.NOVO_TESTAMENTO
    ),
    QuizQuestion(
      id = 143,
      question = "Qual patriarca comprou a caverna de Macpela como sepultura para sua família?",
      options = listOf("Abraão", "Isaque", "Jacó", "José"),
      correctOptionIndex = 0,
      biblicalReference = "Gênesis 23:17-19",
      explanation = "Abraão comprou de Efrom heteu a caverna de Macpela para sepultar sua amada Sara.",
      difficulty = QuizDifficulty.DIFICIL,
      category = QuizCategory.ANTIGO_TESTAMENTO
    ),
    QuizQuestion(
      id = 144,
      question = "Quem teve a primogenitura vendida por um prato de lentilhas vermelhas?",
      options = listOf("Jacó", "Esaú", "Ruben", "Manassés"),
      correctOptionIndex = 1,
      biblicalReference = "Gênesis 25:29-34",
      explanation = "Esaú desprezou a bênção da primogenitura vendendo-a a Jacó por comida passageira.",
      difficulty = QuizDifficulty.FACIL,
      category = QuizCategory.PERSONAGENS
    ),
    QuizQuestion(
      id = 145,
      question = "Qual foi o novo nome dado por Deus a Jacó após ele lutar com o anjo em Peniel?",
      options = listOf("Israel", "Efraim", "Judá", "Abraão"),
      correctOptionIndex = 0,
      biblicalReference = "Gênesis 32:28",
      explanation = "Disse o anjo: 'Não te chamarás mais Jacó, mas Israel, pois lutaste com Deus e com os homens e prevaleceste'.",
      difficulty = QuizDifficulty.FACIL,
      category = QuizCategory.ANTIGO_TESTAMENTO
    ),
    QuizQuestion(
      id = 146,
      question = "Quem era o irmão mais novo e único de sangue materno completo de José no Egito?",
      options = listOf("Simeão", "Benjamim", "Dan", "Zebulom"),
      correctOptionIndex = 1,
      biblicalReference = "Gênesis 35:24; 43:29",
      explanation = "Benjamim era o filho caçula de Raquel e o irmão favorito de José.",
      difficulty = QuizDifficulty.FACIL,
      category = QuizCategory.PERSONAGENS
    ),
    QuizQuestion(
      id = 147,
      question = "Qual vara floresceu, brotou botões e produziu amêndoas maduras para confirmar o sacerdócio ordenado por Deus?",
      options = listOf("A vara de Moisés", "A vara de Arão", "A vara de Josué", "A vara de Hur"),
      correctOptionIndex = 1,
      biblicalReference = "Números 17:8",
      explanation = "A vara de Arão pela casa de Levi floresceu miraculosamente e foi guardada na arca.",
      difficulty = QuizDifficulty.MEDIO,
      category = QuizCategory.ANTIGO_TESTAMENTO
    ),
    QuizQuestion(
      id = 148,
      question = "Qual dos dez mandamentos é o primeiro acompanhado de uma promessa expressa?",
      options = listOf("Não matarás", "Honra a teu pai e a tua mãe", "Não terás outros deuses", "Lembra-te do sábado"),
      correctOptionIndex = 1,
      biblicalReference = "Êxodo 20:12; Efésios 6:2",
      explanation = "'Honra teu pai e tua mãe... para que se prolonguem os teus dias na terra que o Senhor teu Deus te dá'.",
      difficulty = QuizDifficulty.FACIL,
      category = QuizCategory.ANTIGO_TESTAMENTO
    ),
    QuizQuestion(
      id = 149,
      question = "Qual era o nome da cidade refúgio governada pelo rei Melquisedeque nos dias de Abraão?",
      options = listOf("Hebrom", "Salém", "Siquém", "Betel"),
      correctOptionIndex = 1,
      biblicalReference = "Gênesis 14:18; Hebreus 7:1-2",
      explanation = "Melquisedeque, rei de Salém (que significa paz), sacerdote do Deus Altíssimo.",
      difficulty = QuizDifficulty.DIFICIL,
      category = QuizCategory.ANTIGO_TESTAMENTO
    ),
    QuizQuestion(
      id = 150,
      question = "Quem foi escolhido para ser o porta-voz de Moisés perante Faraó por ter facilidade de falar?",
      options = listOf("Josué", "Arão", "Hur", "Jitro"),
      correctOptionIndex = 1,
      biblicalReference = "Êxodo 4:14-16",
      explanation = "Arão, o levita, era irmão de Moisés e falou ao povo em nome de Moisés.",
      difficulty = QuizDifficulty.FACIL,
      category = QuizCategory.PERSONAGENS
    ),
    QuizQuestion(
      id = 151,
      question = "Qual o nome do sogro de Moisés que lhe deu conselhos sobre delegar a liderança jurídica e administrativa?",
      options = listOf("Jitro (Reuel)", "Laban", "Balac", "Balaão"),
      correctOptionIndex = 0,
      biblicalReference = "Êxodo 18:17-24",
      explanation = "Jitro, sacerdote de Midiã, aconselhou Moisés a escolher homens retos para chefes de mil, cem, cinquenta e dez.",
      difficulty = QuizDifficulty.MEDIO,
      category = QuizCategory.PERSONAGENS
    ),
    QuizQuestion(
      id = 152,
      question = "O que foi colocado dentro da Arca da Aliança além das tábuas da Lei?",
      options = listOf("O vaso de ouro com maná e a vara de Arão", "A harpa de Davi e o azeite", "A túnica de José", "As vestes sacerdotais"),
      correctOptionIndex = 0,
      biblicalReference = "Hebreus 9:4",
      explanation = "A arca continha um vaso de ouro com maná, a vara de Arão que florescera e as tábuas da aliança.",
      difficulty = QuizDifficulty.MEDIO,
      category = QuizCategory.ANTIGO_TESTAMENTO
    ),
    QuizQuestion(
      id = 153,
      question = "Quem foi o sucessor direto de Moisés na liderança de Israel rumo à terra prometida?",
      options = listOf("Arão", "Josué", "Calebe", "Eleazar"),
      correctOptionIndex = 1,
      biblicalReference = "Josué 1:1-2",
      explanation = "Após a morte de Moisés, Deus falou a Josué, filho de Num: 'Levanta-te e passa este Jordão'.",
      difficulty = QuizDifficulty.FACIL,
      category = QuizCategory.PERSONAGENS
    ),
    QuizQuestion(
      id = 154,
      question = "Qual rei de Babilônia libertou o rei Joaquim da prisão de Judá e o colocou à sua mesa?",
      options = listOf("Evil-Merodaque", "Belsazar", "Dario", "Artaxerxes"),
      correctOptionIndex = 0,
      biblicalReference = "2 Reis 25:27-28",
      explanation = "Evil-Merodaque ergueu a cabeça de Joaquim e falou-lhe benignamente no primeiro ano de seu reino.",
      difficulty = QuizDifficulty.DIFICIL,
      category = QuizCategory.ANTIGO_TESTAMENTO
    ),
    QuizQuestion(
      id = 155,
      question = "Quem profetizou: 'Eis que a virgem conceberá, e dará à luz um filho, e chamará o seu nome Emanuel'?",
      options = listOf("Jeremias", "Isaías", "Miqueias", "Daniel"),
      correctOptionIndex = 1,
      biblicalReference = "Isaías 7:14",
      explanation = "A célebre profecia messiânica de Emanuel ('Deus conosco') foi dada pelo profeta Isaías.",
      difficulty = QuizDifficulty.FACIL,
      category = QuizCategory.PROFETAS
    ),
    QuizQuestion(
      id = 156,
      question = "Em qual monte Moisés contemplou a terra prometida antes de ser recolhido por Deus?",
      options = listOf("Monte Hermom", "Monte Nebo (cume de Pisga)", "Monte Sião", "Monte Tabor"),
      correctOptionIndex = 1,
      biblicalReference = "Deuteronômio 34:1",
      explanation = "Moisés subiu ao monte Nebo, ao cume de Pisga, defronte de Jericó, e o Senhor mostrou-lhe toda a terra.",
      difficulty = QuizDifficulty.MEDIO,
      category = QuizCategory.ANTIGO_TESTAMENTO
    ),
    QuizQuestion(
      id = 157,
      question = "Quem foi a rainha ímpia que perseguiu os profetas do Senhor e jurou tirar a vida de Elias?",
      options = listOf("Atalia", "Jezabel", "Herodias", "Vasti"),
      correctOptionIndex = 1,
      biblicalReference = "1 Reis 19:1-2",
      explanation = "Jezabel enviou mensageiro a Elias jurando tirar sua vida, levando o profeta ao deserto.",
      difficulty = QuizDifficulty.FACIL,
      category = QuizCategory.PERSONAGENS
    ),
    QuizQuestion(
      id = 158,
      question = "Qual rei persa autorizou os judeus a retornarem a Jerusalém para reedificar a Casa de Deus?",
      options = listOf("Xerxes", "Ciro", "Dario", "Alexandre"),
      correctOptionIndex = 1,
      biblicalReference = "Esdras 1:1-2; Isaías 45:1",
      explanation = "Ciro, rei da Pérsia, proclamou edito permitindo o retorno dos judeus exilados.",
      difficulty = QuizDifficulty.MEDIO,
      category = QuizCategory.ANTIGO_TESTAMENTO
    ),
    QuizQuestion(
      id = 159,
      question = "Qual homem justo de Cafarnaum teve a fé elogiada por Jesus ao dizer: 'Dize somente uma palavra, e o meu criado há de sarar'?",
      options = listOf("Um fariseu", "O centurião romano", "O príncipe da sinagoga", "Um doutor da lei"),
      correctOptionIndex = 1,
      biblicalReference = "Mateus 8:8-10",
      explanation = "Jesus maravilhou-se e disse: 'Em verdade vos digo que nem mesmo em Israel encontrei tamanha fé'.",
      difficulty = QuizDifficulty.FACIL,
      category = QuizCategory.MILAGRES_E_PARABOLAS
    ),
    QuizQuestion(
      id = 160,
      question = "Qual dos evangelistas não fazia parte dos doze apóstolos originais, mas foi companheiro próximo de Pedro?",
      options = listOf("Mateus", "Marcos", "João", "Judas"),
      correctOptionIndex = 1,
      biblicalReference = "1 Pedro 5:13",
      explanation = "Marcos (João Marcos) acompanhou Pedro e registrou o Evangelho dinâmico voltado às ações do Servo de Deus.",
      difficulty = QuizDifficulty.MEDIO,
      category = QuizCategory.EVANGELHOS
    ),
    QuizQuestion(
      id = 161,
      question = "Qual livro da Bíblia não contém explicitamente o nome de Deus em seu texto original, embora demonstre Sua providência maravilhosa em cada detalhe?",
      options = listOf("Cânticos", "Ester", "Rute", "Eclesiastes"),
      correctOptionIndex = 1,
      biblicalReference = "Livro de Ester",
      explanation = "O livro de Ester não menciona o nome sagrado de Deus diretamente, mas Sua soberana proteção é evidente em toda a narrativa.",
      difficulty = QuizDifficulty.MEDIO,
      category = QuizCategory.ANTIGO_TESTAMENTO
    ),
    QuizQuestion(
      id = 162,
      question = "Qual profeta foi enviado à cidade assíria de Nínive e ficou contrariado quando a cidade se arrependeu?",
      options = listOf("Naum", "Jonas", "Ageu", "Habacuque"),
      correctOptionIndex = 1,
      biblicalReference = "Jonas 4:1-2",
      explanation = "Jonas desgostou-se grandemente porque Deus teve misericórdia de Nínive após o arrependimento geral.",
      difficulty = QuizDifficulty.FACIL,
      category = QuizCategory.PROFETAS
    ),
    QuizQuestion(
      id = 163,
      question = "Qual o nome da montanha onde a arca do concerto foi colocada e onde Davi ergueu sua tenda de adoração?",
      options = listOf("Monte Hermom", "Monte Sião", "Monte Sinai", "Monte Carmelo"),
      correctOptionIndex = 1,
      biblicalReference = "2 Samuel 6:12; Salmos 132:13",
      explanation = "O Senhor escolheu a Sião e a desejou para Sua morada perpétua.",
      difficulty = QuizDifficulty.MEDIO,
      category = QuizCategory.ANTIGO_TESTAMENTO
    ),
    QuizQuestion(
      id = 164,
      question = "Qual profeta predisse que Jesus nasceria da linhagem de Jessé como um renovo de suas raízes?",
      options = listOf("Isaías", "Jeremias", "Zacarias", "Malaquias"),
      correctOptionIndex = 0,
      biblicalReference = "Isaías 11:1",
      explanation = "Porque brotará um rebento do tronco de Jessé, e das suas raízes um renovo frutificará.",
      difficulty = QuizDifficulty.MEDIO,
      category = QuizCategory.PROFETAS
    ),
    QuizQuestion(
      id = 165,
      question = "Quantas vezes o profeta Eliseu mandou o rei Jeoás ferir a terra com as flechas?",
      options = listOf("Uma vez", "Três vezes", "Sete vezes", "Dez vezes"),
      correctOptionIndex = 1,
      biblicalReference = "2 Reis 13:18-19",
      explanation = "Jeoás feriu a terra três vezes e cessou; o homem de Deus indignou-se porque se ferisse cinco ou seis vezes consumiria a Síria.",
      difficulty = QuizDifficulty.DIFICIL,
      category = QuizCategory.PROFETAS
    ),
    QuizQuestion(
      id = 166,
      question = "Quem foi o primeiro sumo sacerdote da nação de Israel consagrado no tabernáculo?",
      options = listOf("Moisés", "Arão", "Eleazar", "Eli"),
      correctOptionIndex = 1,
      biblicalReference = "Êxodo 28:1",
      explanation = "Arão e seus filhos foram apartados para servirem como sacerdotes perpetuamente.",
      difficulty = QuizDifficulty.FACIL,
      category = QuizCategory.PERSONAGENS
    ),
    QuizQuestion(
      id = 167,
      question = "Qual cidade cananeia foi tomada após o povo dar voltas em silêncio durante seis dias e gritar no sétimo dia?",
      options = listOf("Ai", "Jericó", "Hazor", "Gibeom"),
      correctOptionIndex = 1,
      biblicalReference = "Josué 6:15-16",
      explanation = "No sétimo dia rodearam a cidade sete vezes e as muralhas ruíram.",
      difficulty = QuizDifficulty.FACIL,
      category = QuizCategory.ANTIGO_TESTAMENTO
    ),
    QuizQuestion(
      id = 168,
      question = "Quem foi o filho pródigo de Davi que se rebelou, tentou usurpar o trono e morreu preso pelos cabelos numa árvore?",
      options = listOf("Amnon", "Adonias", "Absalão", "Salomão"),
      correctOptionIndex = 2,
      biblicalReference = "2 Samuel 18:9",
      explanation = "A cabeça de Absalão prendeu-se num carvalho e ele ficou suspenso entre o céu e a terra.",
      difficulty = QuizDifficulty.MEDIO,
      category = QuizCategory.PERSONAGENS
    ),
    QuizQuestion(
      id = 169,
      question = "Qual filho de Saul era coxo de ambos os pés e foi convidado por Davi para comer continuamente à mesa do rei?",
      options = listOf("Mefibosete", "Jônatas", "Isbosete", "Armoni"),
      correctOptionIndex = 0,
      biblicalReference = "2 Samuel 9:7-13",
      explanation = "Davi usou de bondade para com Mefibosete em honra à aliança de amor com Jônatas.",
      difficulty = QuizDifficulty.MEDIO,
      category = QuizCategory.PERSONAGENS
    ),
    QuizQuestion(
      id = 170,
      question = "Quem curou as águas amargas de Mara lançando uma árvore nas águas conforme o Senhor instruiu?",
      options = listOf("Arão", "Moisés", "Josué", "Hur"),
      correctOptionIndex = 1,
      biblicalReference = "Êxodo 15:23-25",
      explanation = "O Senhor mostrou a Moisés uma árvore e ele lançou-a nas águas, tornando-as doces.",
      difficulty = QuizDifficulty.MEDIO,
      category = QuizCategory.MILAGRES_E_PARABOLAS
    ),
    QuizQuestion(
      id = 171,
      question = "Qual profeta foi alimentado por uma viúva de Sarepta cujo azeite da botija e farinha da panela nunca acabaram?",
      options = listOf("Ezequiel", "Elias", "Eliseu", "Amós"),
      correctOptionIndex = 1,
      biblicalReference = "1 Reis 17:14-16",
      explanation = "A farinha da panela não se acabou e o azeite da botija não faltou, conforme a palavra de Deus por Elias.",
      difficulty = QuizDifficulty.FACIL,
      category = QuizCategory.PROFETAS
    ),
    QuizQuestion(
      id = 172,
      question = "Quem ressuscitou o filho da mulher sunamita deitando-se sobre a criança até seu corpo aquecer?",
      options = listOf("Elias", "Eliseu", "Samuel", "Isaías"),
      correctOptionIndex = 1,
      biblicalReference = "2 Reis 4:32-35",
      explanation = "Eliseu orou ao Senhor, aqueceu a criança, o menino espirrou sete vezes e abriu os olhos.",
      difficulty = QuizDifficulty.MEDIO,
      category = QuizCategory.PROFETAS
    ),
    QuizQuestion(
      id = 173,
      question = "Qual sacerdote ensinou a Lei de Deus ao povo de Jerusalém após o retorno do cativeiro lendo em pé sobre um estrado de madeira?",
      options = listOf("Esdras", "Neemias", "Josué", "Zorobabel"),
      correctOptionIndex = 0,
      biblicalReference = "Neemias 8:1-5",
      explanation = "O escriba Esdras trouxe o livro da Lei diante da congregação e leu desde a alva até o meio-dia.",
      difficulty = QuizDifficulty.MEDIO,
      category = QuizCategory.ANTIGO_TESTAMENTO
    ),
    QuizQuestion(
      id = 174,
      question = "Quem foi o profeta que enfrentou o rei Acabe e profetizou que os cães lamberiam o sangue dele no mesmo lugar onde lamberam o sangue de Nabote?",
      options = listOf("Micaías", "Elias", "Eliseu", "Jeú"),
      correctOptionIndex = 1,
      biblicalReference = "1 Reis 21:19",
      explanation = "Elias profetizou o juízo sobre a casa de Acabe pela injustiça e morte do inocente Nabote.",
      difficulty = QuizDifficulty.DIFICIL,
      category = QuizCategory.PROFETAS
    ),
    QuizQuestion(
      id = 175,
      question = "Qual discípulo de Jesus era conhecido como 'zelote' antes de ser chamado?",
      options = listOf("Simão, o Zelote", "Judas Tadeu", "Tiago menor", "Bartolomeu"),
      correctOptionIndex = 0,
      biblicalReference = "Lucas 6:15",
      explanation = "Simão, chamado Zelote, pertencia anteriormente ao grupo zeloso patriótico judaico.",
      difficulty = QuizDifficulty.MEDIO,
      category = QuizCategory.EVANGELHOS
    ),
    QuizQuestion(
      id = 176,
      question = "Em qual tanque o cego enviado por Jesus lavou os olhos e voltou vendo?",
      options = listOf("Betesda", "Siloé", "Querite", "Quisom"),
      correctOptionIndex = 1,
      biblicalReference = "João 9:7",
      explanation = "Jesus disse: 'Vai, lava-te no tanque de Siloé (que significa Enviado)'. Foi, lavou-se e voltou vendo.",
      difficulty = QuizDifficulty.FACIL,
      category = QuizCategory.MILAGRES_E_PARABOLAS
    ),
    QuizQuestion(
      id = 177,
      question = "Qual apóstolo foi arrebatado até ao terceiro céu e ouviu palavras inefáveis que ao homem não é lícito falar?",
      options = listOf("Pedro", "João", "Paulo", "Tiago"),
      correctOptionIndex = 2,
      biblicalReference = "2 Coríntios 12:2-4",
      explanation = "O apóstolo Paulo relata sua experiência sublime de revelação no paraíso celestial.",
      difficulty = QuizDifficulty.MEDIO,
      category = QuizCategory.NOVO_TESTAMENTO
    ),
    QuizQuestion(
      id = 178,
      question = "Qual casal de cooperadores acompanhou Paulo e instruiu Apolo com mais exatidão no caminho de Deus?",
      options = listOf("Áquila e Priscila", "Ananias e Safira", "Zacarias e Isabel", "Elimeleque e Noemi"),
      correctOptionIndex = 0,
      biblicalReference = "Atos 18:26",
      explanation = "Ouvindo a Apolo na sinagoga, Áquila e Priscila o recolheram e declararam com mais precisão a palavra.",
      difficulty = QuizDifficulty.MEDIO,
      category = QuizCategory.PERSONAGENS
    ),
    QuizQuestion(
      id = 179,
      question = "Quem foi o primeiro filho primogênito de Adão e Eva?",
      options = listOf("Abel", "Caim", "Sete", "Enoque"),
      correctOptionIndex = 1,
      biblicalReference = "Gênesis 4:1",
      explanation = "Eva concebeu e deu à luz a Caim, dizendo: 'Adquiri um varão do Senhor'.",
      difficulty = QuizDifficulty.FACIL,
      category = QuizCategory.ANTIGO_TESTAMENTO
    ),
    QuizQuestion(
      id = 180,
      question = "Qual o nome da cidade onde o Senhor confundiu as línguas de todos os habitantes da terra?",
      options = listOf("Ur dos Caldeus", "Babel", "Nínive", "Nod"),
      correctOptionIndex = 1,
      biblicalReference = "Gênesis 11:9",
      explanation = "Por isso se chamou o seu nome Babel, porquanto ali confundiu o Senhor a língua de toda a terra.",
      difficulty = QuizDifficulty.FACIL,
      category = QuizCategory.ANTIGO_TESTAMENTO
    ),
    QuizQuestion(
      id = 181,
      question = "Qual mulher estéril cantou: 'O Senhor empobrece e enriquece; abaixa e também exalta' após ter seu filho?",
      options = listOf("Ana", "Sara", "Isabel", "Raquel"),
      correctOptionIndex = 0,
      biblicalReference = "1 Samuel 2:1-10",
      explanation = "O cântico de gratidão de Ana é um dos mais belos hinos de exaltação ao poder de Deus nas Escrituras.",
      difficulty = QuizDifficulty.MEDIO,
      category = QuizCategory.PERSONAGENS
    ),
    QuizQuestion(
      id = 182,
      question = "Qual rei de Judá escondeu-se no Templo durante seis anos quando a ímpia Atalia tentou matar todos os herdeiros?",
      options = listOf("Joás", "Josias", "Ezequias", "Uzias"),
      correctOptionIndex = 0,
      biblicalReference = "2 Reis 11:2-3",
      explanation = "O menino Joás foi escondido por sua tia Joseba e pelo sacerdote Joiada na Casa do Senhor.",
      difficulty = QuizDifficulty.DIFICIL,
      category = QuizCategory.PROFETAS
    ),
    QuizQuestion(
      id = 183,
      question = "Quem foi lançado vivo num poço profundo de lama por profetizar a queda de Jerusalém?",
      options = listOf("Isaías", "Jeremias", "Ezequiel", "Miqueias"),
      correctOptionIndex = 1,
      biblicalReference = "Jeremias 38:6",
      explanation = "Jeremias atolou na lama na cisterna de Malquias, sendo depois resgatado pelo etíope Ebede-Meleque com cordas e panos.",
      difficulty = QuizDifficulty.MEDIO,
      category = QuizCategory.PROFETAS
    ),
    QuizQuestion(
      id = 184,
      question = "Quem teve a visão dos quatro animais e das quatro rodas cheias de olhos junto ao rio Quebar?",
      options = listOf("Ezequiel", "Daniel", "Zacarias", "Isaías"),
      correctOptionIndex = 0,
      biblicalReference = "Ezequiel 1:1-16",
      explanation = "Ezequiel contemplou a carruagem da glória divina em visões celestiais no cativeiro babilônico.",
      difficulty = QuizDifficulty.MEDIO,
      category = QuizCategory.PROFETAS
    ),
    QuizQuestion(
      id = 185,
      question = "Qual profeta falou sobre o derramamento do Espírito Santo sobre toda a carne cumprido no dia de Pentecostes?",
      options = listOf("Joel", "Amós", "Obadias", "Malaquias"),
      correctOptionIndex = 0,
      biblicalReference = "Joel 2:28; Atos 2:16-17",
      explanation = "Pedro citou o profeta Joel: 'E nos últimos dias acontecerá, diz Deus, que do meu Espírito derramarei sobre toda a carne'.",
      difficulty = QuizDifficulty.MEDIO,
      category = QuizCategory.PROFETAS
    ),
    QuizQuestion(
      id = 186,
      question = "Qual profeta era vaqueiro e colhedor de sicômoros antes de ser chamado por Deus?",
      options = listOf("Amós", "Oséias", "Miqueias", "Sofonias"),
      correctOptionIndex = 0,
      biblicalReference = "Amós 7:14",
      explanation = "Amós declarou: 'Não sou profeta, nem filho de profeta, mas boieiro e cultivador de sicômoros'.",
      difficulty = QuizDifficulty.DIFICIL,
      category = QuizCategory.PROFETAS
    ),
    QuizQuestion(
      id = 187,
      question = "Quem profetizou o julgamento exclusivo contra a nação orgulhosa de Edom?",
      options = listOf("Obadias", "Naum", "Habacuque", "Ageu"),
      correctOptionIndex = 0,
      biblicalReference = "Obadias 1:1-4",
      explanation = "O livro de Obadias, o menor do Antigo Testamento, profetiza a queda de Edom que habitava nas fendas das rochas.",
      difficulty = QuizDifficulty.DIFICIL,
      category = QuizCategory.PROFETAS
    ),
    QuizQuestion(
      id = 188,
      question = "Qual profeta profetizou a destruição final da cidade de Nínive mais de um século após Jonas?",
      options = listOf("Naum", "Habacuque", "Zacarias", "Malaquias"),
      correctOptionIndex = 0,
      biblicalReference = "Naum 1:1",
      explanation = "O profeta Naum de Elcos profetizou a sentença final e o juízo sobre a sanguinária Nínive.",
      difficulty = QuizDifficulty.DIFICIL,
      category = QuizCategory.PROFETAS
    ),
    QuizQuestion(
      id = 189,
      question = "Qual profeta incentivou Zorobabel e Josué a retomarem a reconstrução do Templo dizendo: 'Minha é a prata, e meu é o ouro'?",
      options = listOf("Ageu", "Zacarias", "Malaquias", "Esdras"),
      correctOptionIndex = 0,
      biblicalReference = "Ageu 2:8-9",
      explanation = "Ageu profetizou: 'A glória desta última casa será maior do que a da primeira, diz o Senhor dos Exércitos'.",
      difficulty = QuizDifficulty.MEDIO,
      category = QuizCategory.PROFETAS
    ),
    QuizQuestion(
      id = 190,
      question = "Qual profeta previu que o Messias entraria em Jerusalém humilde e montado sobre um jumentinho?",
      options = listOf("Zacarias", "Isaías", "Jeremias", "Malaquias"),
      correctOptionIndex = 0,
      biblicalReference = "Zacarias 9:9; Mateus 21:5",
      explanation = "Zacarias profetizou: 'Alegra-te muito, ó filha de Sião... eis que o teu Rei virá a ti, justo e Salvador, pobre, e montado sobre um jumento'.",
      difficulty = QuizDifficulty.MEDIO,
      category = QuizCategory.PROFETAS
    ),
    QuizQuestion(
      id = 191,
      question = "Quantos talentos de prata o servo mau escondeu na terra na parábola dos talentos?",
      options = listOf("1 talento", "2 talentos", "5 talentos", "10 talentos"),
      correctOptionIndex = 0,
      biblicalReference = "Mateus 25:18-25",
      explanation = "O que recebera um talento foi, cavou na terra e escondeu o dinheiro de seu senhor por medo e negligência.",
      difficulty = QuizDifficulty.FACIL,
      category = QuizCategory.MILAGRES_E_PARABOLAS
    ),
    QuizQuestion(
      id = 192,
      question = "Quantas virgens eram prudentes e quantas eram néscias (loucas) na parábola das dez virgens?",
      options = listOf("5 prudentes e 5 néscias", "7 prudentes e 3 néscias", "9 prudentes e 1 néscia", "8 prudentes e 2 néscias"),
      correctOptionIndex = 0,
      biblicalReference = "Mateus 25:1-2",
      explanation = "Cinco delas eram prudentes, e cinco loucas; as prudentes levaram azeite em suas vasilhas com as lâmpadas.",
      difficulty = QuizDifficulty.FACIL,
      category = QuizCategory.MILAGRES_E_PARABOLAS
    ),
    QuizQuestion(
      id = 193,
      question = "O que Jesus disse à tempestade furiosa no Mar da Galileia quando os discípulos temiam afundar?",
      options = listOf("'Cala-te, aquieta-te!'", "'Vento, afasta-te!'", "'Anjos, segurai o barco!'", "'Orai e vigiai!'"),
      correctOptionIndex = 0,
      biblicalReference = "Marcos 4:39",
      explanation = "Despertando, repreendeu o vento e disse ao mar: 'Cala-te, aquieta-te'. E o vento se aquietou, e houve grande bonança.",
      difficulty = QuizDifficulty.FACIL,
      category = QuizCategory.MILAGRES_E_PARABOLAS
    ),
    QuizQuestion(
      id = 194,
      question = "Qual era o nome do mendigo cego e de seu pai curado por Jesus perto da saída de Jericó?",
      options = listOf("Bartimeu, filho de Timeu", "Lázaro, filho de Simão", "Zaqueu, filho de Levi", "Malco, filho de Caifás"),
      correctOptionIndex = 0,
      biblicalReference = "Marcos 10:46",
      explanation = "Bartimeu significa literalmente 'filho de Timeu' em aramaico.",
      difficulty = QuizDifficulty.MEDIO,
      category = QuizCategory.MILAGRES_E_PARABOLAS
    ),
    QuizQuestion(
      id = 195,
      question = "Qual foi o servo do sumo sacerdote que teve a orelha direita decepada por Pedro e depois curada por Jesus no Getsêmani?",
      options = listOf("Malco", "Barrabás", "Demas", "Alexandre"),
      correctOptionIndex = 0,
      biblicalReference = "João 18:10; Lucas 22:51",
      explanation = "Jesus tocou-lhe a orelha e o curou, demonstrando misericórdia até para com os captores.",
      difficulty = QuizDifficulty.MEDIO,
      category = QuizCategory.EVANGELHOS
    ),
    QuizQuestion(
      id = 196,
      question = "Quem pediu a cabeça de João Batista num prato por instigação de sua mãe Herodias?",
      options = listOf("Salomé (filha de Herodias)", "Drusila", "Berenice", "Atalia"),
      correctOptionIndex = 0,
      biblicalReference = "Mateus 14:6-11",
      explanation = "A jovem dançou diante do rei Herodes e, instruída pela mãe, exigiu a cabeça do profeta.",
      difficulty = QuizDifficulty.MEDIO,
      category = QuizCategory.EVANGELHOS
    ),
    QuizQuestion(
      id = 197,
      question = "Qual homem justo da sinagoga suplicou a Jesus que fosse à sua casa curar sua filha de doze anos que estava à morte?",
      options = listOf("Jairo", "Centurião", "Zaqueu", "Nicodemos"),
      correctOptionIndex = 0,
      biblicalReference = "Marcos 5:22-23; Lucas 8:41",
      explanation = "Jairo, um dos principais da sinagoga, prostrou-se aos pés de Jesus e a menina foi ressuscitada com as palavras: 'Talita cumi'.",
      difficulty = QuizDifficulty.FACIL,
      category = QuizCategory.MILAGRES_E_PARABOLAS
    ),
    QuizQuestion(
      id = 198,
      question = "Por quantos anos uma mulher sofreu com um fluxo de sangue antes de tocar na orla das vestes de Jesus e ser curada?",
      options = listOf("7 anos", "12 anos", "18 anos", "38 anos"),
      correctOptionIndex = 1,
      biblicalReference = "Lucas 8:43-48",
      explanation = "Uma mulher que havia doze anos tinha um fluxo de sangue tocou a orla da vestimenta e foi imediatamente sarada.",
      difficulty = QuizDifficulty.FACIL,
      category = QuizCategory.MILAGRES_E_PARABOLAS
    ),
    QuizQuestion(
      id = 199,
      question = "Qual livro do Novo Testamento declara que 'a oração feita por um justo pode muito em seus efeitos'?",
      options = listOf("Tiago", "1 Pedro", "1 João", "Hebreus"),
      correctOptionIndex = 0,
      biblicalReference = "Tiago 5:16",
      explanation = "A epístola de Tiago ressalta o poder eficaz e a perseverança da oração da fé.",
      difficulty = QuizDifficulty.MEDIO,
      category = QuizCategory.NOVO_TESTAMENTO
    ),
    QuizQuestion(
      id = 200,
      question = "Em Apocalipse 22:20, qual é a promessa final de Cristo e a resposta da Igreja que encerra as Escrituras?",
      options = listOf("'Cedo venho! Amém; vem, Senhor Jesus!'", "'Ide por todo o mundo'", "'A paz seja convosco'", "'Tudo está consumado'"),
      correctOptionIndex = 0,
      biblicalReference = "Apocalipse 22:20",
      explanation = "Aquele que testifica estas coisas diz: 'Certamente cedo venho'. Amém! Ora vem, Senhor Jesus!",
      difficulty = QuizDifficulty.FACIL,
      category = QuizCategory.NOVO_TESTAMENTO
    )
  )
}
