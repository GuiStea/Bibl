package com.example.data

import com.example.model.QuizCategory
import com.example.model.QuizDifficulty
import com.example.model.QuizQuestion

object QuizQuestionsPart1 {
  val questions: List<QuizQuestion> = listOf(
    QuizQuestion(
      id = 1,
      question = "Qual é o primeiro livro da Bíblia?",
      options = listOf("Êxodo", "Gênesis", "Levítico", "Salmos"),
      correctOptionIndex = 1,
      biblicalReference = "Gênesis 1:1",
      explanation = "Gênesis é o livro das origens e inaugura as Sagradas Escrituras.",
      difficulty = QuizDifficulty.FACIL,
      category = QuizCategory.ANTIGO_TESTAMENTO
    ),
    QuizQuestion(
      id = 2,
      question = "Quantos dias durou o dilúvio de chuva sobre a terra na época de Noé?",
      options = listOf("7 dias", "40 dias e 40 noites", "100 dias", "150 dias"),
      correctOptionIndex = 1,
      biblicalReference = "Gênesis 7:12",
      explanation = "A chuva caiu sobre a terra durante quarenta dias e quarenta noites.",
      difficulty = QuizDifficulty.FACIL,
      category = QuizCategory.ANTIGO_TESTAMENTO
    ),
    QuizQuestion(
      id = 3,
      question = "Quem foi colocado num cesto de junco no rio Nilo ainda bebê?",
      options = listOf("José", "Moisés", "Arão", "Josué"),
      correctOptionIndex = 1,
      biblicalReference = "Êxodo 2:3",
      explanation = "A mãe de Moisés escondeu-o num cesto no rio Nilo para salvá-lo do decreto de Faraó.",
      difficulty = QuizDifficulty.FACIL,
      category = QuizCategory.PERSONAGENS
    ),
    QuizQuestion(
      id = 4,
      question = "Qual mar se abriu para o povo de Israel passar a pé enxuto?",
      options = listOf("Mar Morto", "Mar da Galileia", "Mar Vermelho", "Mar Mediterrâneo"),
      correctOptionIndex = 2,
      biblicalReference = "Êxodo 14:21-22",
      explanation = "Deus abriu o Mar Vermelho através de Moisés com um forte vento oriental.",
      difficulty = QuizDifficulty.FACIL,
      category = QuizCategory.MILAGRES_E_PARABOLAS
    ),
    QuizQuestion(
      id = 5,
      question = "Em qual monte Moisés recebeu as tábuas dos Dez Mandamentos?",
      options = listOf("Monte Carmelo", "Monte Sinai", "Monte Sião", "Monte Hermom"),
      correctOptionIndex = 1,
      biblicalReference = "Êxodo 19:20",
      explanation = "O Senhor desceu sobre o cume do Monte Sinai e chamou Moisés ao cume.",
      difficulty = QuizDifficulty.FACIL,
      category = QuizCategory.ANTIGO_TESTAMENTO
    ),
    QuizQuestion(
      id = 6,
      question = "Quem derrotou o gigante Golias usando apenas uma funda e uma pedra?",
      options = listOf("Saul", "Salomão", "Davi", "Sansão"),
      correctOptionIndex = 2,
      biblicalReference = "1 Samuel 17:49",
      explanation = "O jovem Davi, confiando no Deus dos exércitos de Israel, abateu o filisteu Golias.",
      difficulty = QuizDifficulty.FACIL,
      category = QuizCategory.PERSONAGENS
    ),
    QuizQuestion(
      id = 7,
      question = "Qual homem foi engolido por um grande peixe após tentar fugir de Deus?",
      options = listOf("Jonas", "Jó", "Jeremias", "Joel"),
      correctOptionIndex = 0,
      biblicalReference = "Jonas 1:17",
      explanation = "Deus preparou um grande peixe para engolir Jonas quando fugia para Társis.",
      difficulty = QuizDifficulty.FACIL,
      category = QuizCategory.PROFETAS
    ),
    QuizQuestion(
      id = 8,
      question = "Qual rei pediu sabedoria a Deus em vez de riquezas ou vida longa?",
      options = listOf("Davi", "Roboão", "Salomão", "Ezequias"),
      correctOptionIndex = 2,
      biblicalReference = "1 Reis 3:9-12",
      explanation = "Salomão pediu um coração entendido para julgar o povo e Deus concedeu-lhe imensa sabedoria.",
      difficulty = QuizDifficulty.FACIL,
      category = QuizCategory.PROFETAS
    ),
    QuizQuestion(
      id = 9,
      question = "Quem foi lançado na cova dos leões e saiu ileso por fidelidade a Deus?",
      options = listOf("Daniel", "Sadraque", "Ezequiel", "Isaías"),
      correctOptionIndex = 0,
      biblicalReference = "Daniel 6:22",
      explanation = "O anjo de Deus fechou a boca dos leões porque Daniel foi achado inocente diante Dele.",
      difficulty = QuizDifficulty.FACIL,
      category = QuizCategory.PROFETAS
    ),
    QuizQuestion(
      id = 10,
      question = "Em qual cidade nasceu Jesus Cristo?",
      options = listOf("Nazaré", "Jerusalém", "Belém", "Cafarnaum"),
      correctOptionIndex = 2,
      biblicalReference = "Miqueias 5:2 / Lucas 2:4-7",
      explanation = "Conforme as profecias, Jesus nasceu em Belém da Judeia.",
      difficulty = QuizDifficulty.FACIL,
      category = QuizCategory.EVANGELHOS
    ),
    QuizQuestion(
      id = 11,
      question = "Quem batizou Jesus no rio Jordão?",
      options = listOf("Pedro", "João Batista", "Tiago", "André"),
      correctOptionIndex = 1,
      biblicalReference = "Mateus 3:13-17",
      explanation = "João Batista batizou o Senhor Jesus nas águas do rio Jordão.",
      difficulty = QuizDifficulty.FACIL,
      category = QuizCategory.EVANGELHOS
    ),
    QuizQuestion(
      id = 12,
      question = "Quantos discípulos principais (apóstolos) Jesus escolheu?",
      options = listOf("7", "10", "12", "70"),
      correctOptionIndex = 2,
      biblicalReference = "Mateus 10:1-4",
      explanation = "Jesus chamou doze apóstolos para andarem com Ele e pregarem o Evangelho.",
      difficulty = QuizDifficulty.FACIL,
      category = QuizCategory.EVANGELHOS
    ),
    QuizQuestion(
      id = 13,
      question = "Qual foi o primeiro milagre público realizado por Jesus?",
      options = listOf("Multiplicação dos pães", "Transformar água em vinho em Caná", "Cura do cego de Jericó", "Ressurreição de Lázaro"),
      correctOptionIndex = 1,
      biblicalReference = "João 2:1-11",
      explanation = "Em Caná da Galileia, Jesus transformou água em vinho num casamento.",
      difficulty = QuizDifficulty.FACIL,
      category = QuizCategory.MILAGRES_E_PARABOLAS
    ),
    QuizQuestion(
      id = 14,
      question = "Quem negou a Jesus três vezes antes do galo cantar?",
      options = listOf("Judas", "Tomé", "Pedro", "Filipe"),
      correctOptionIndex = 2,
      biblicalReference = "Mateus 26:69-75",
      explanation = "Pedro negou conhecer o Mestre por três vezes e depois chorou amargamente.",
      difficulty = QuizDifficulty.FACIL,
      category = QuizCategory.EVANGELHOS
    ),
    QuizQuestion(
      id = 15,
      question = "Quantos dias Jesus jejuou no deserto antes de ser tentado?",
      options = listOf("3 dias", "14 dias", "40 dias e 40 noites", "70 dias"),
      correctOptionIndex = 2,
      biblicalReference = "Mateus 4:2",
      explanation = "Jesus jejuou quarenta dias e quarenta noites no deserto.",
      difficulty = QuizDifficulty.FACIL,
      category = QuizCategory.EVANGELHOS
    ),
    QuizQuestion(
      id = 16,
      question = "Qual versículo bíblico afirma: 'Porque Deus amou o mundo de tal maneira...'?",
      options = listOf("João 1:1", "João 3:16", "Romanos 8:28", "Salmos 23:1"),
      correctOptionIndex = 1,
      biblicalReference = "João 3:16",
      explanation = "João 3:16 é um dos versículos mais conhecidos que resume o amor salvífico de Deus.",
      difficulty = QuizDifficulty.FACIL,
      category = QuizCategory.EVANGELHOS
    ),
    QuizQuestion(
      id = 17,
      question = "Quem foi ressuscitado por Jesus após quatro dias sepultado?",
      options = listOf("Jairo", "Lázaro", "Estêvão", "Cornélio"),
      correctOptionIndex = 1,
      biblicalReference = "João 11:43-44",
      explanation = "Jesus chamou: 'Lázaro, sai para fora!' e ele saiu atado com as faixas.",
      difficulty = QuizDifficulty.FACIL,
      category = QuizCategory.MILAGRES_E_PARABOLAS
    ),
    QuizQuestion(
      id = 18,
      question = "Qual é o último livro do Novo Testamento?",
      options = listOf("Hebreus", "Judas", "Apocalipse", "Atos"),
      correctOptionIndex = 2,
      biblicalReference = "Apocalipse 22:21",
      explanation = "O Apocalipse (Revelação de João) encerra o cânon bíblico.",
      difficulty = QuizDifficulty.FACIL,
      category = QuizCategory.NOVO_TESTAMENTO
    ),
    QuizQuestion(
      id = 19,
      question = "Quem escreveu a maioria das epístolas do Novo Testamento?",
      options = listOf("Pedro", "João", "Paulo", "Tiago"),
      correctOptionIndex = 2,
      biblicalReference = "Romanos a Filemom",
      explanation = "O apóstolo Paulo escreveu 13 cartas (ou 14 se incluir Hebreus) às igrejas.",
      difficulty = QuizDifficulty.FACIL,
      category = QuizCategory.NOVO_TESTAMENTO
    ),
    QuizQuestion(
      id = 20,
      question = "Qual o nome do jardim onde Jesus orou antes de ser preso?",
      options = listOf("Jardim do Éden", "Getsêmani", "Jardim de Salomão", "Gólgota"),
      correctOptionIndex = 1,
      biblicalReference = "Mateus 26:36",
      explanation = "Jesus foi ao Getsêmani com Seus discípulos para orar ao Pai.",
      difficulty = QuizDifficulty.FACIL,
      category = QuizCategory.EVANGELHOS
    ),
    QuizQuestion(
      id = 21,
      question = "Qual discípulo só acreditou na ressurreição após ver e tocar nas feridas de Jesus?",
      options = listOf("Bartolomeu", "Tomé", "Tadeu", "André"),
      correctOptionIndex = 1,
      biblicalReference = "João 20:24-29",
      explanation = "Tomé disse que só creria se visse nas mãos o sinal dos cravos.",
      difficulty = QuizDifficulty.FACIL,
      category = QuizCategory.EVANGELHOS
    ),
    QuizQuestion(
      id = 22,
      question = "Qual é o Salmo que começa com: 'O Senhor é o meu pastor, nada me faltará'?",
      options = listOf("Salmo 1", "Salmo 23", "Salmo 91", "Salmo 121"),
      correctOptionIndex = 1,
      biblicalReference = "Salmos 23:1",
      explanation = "O Salmo 23 é um cântico clássico de confiança no cuidado do Bom Pastor.",
      difficulty = QuizDifficulty.FACIL,
      category = QuizCategory.ANTIGO_TESTAMENTO
    ),
    QuizQuestion(
      id = 23,
      question = "Quem foi vendido pelos próprios irmãos como escravo e levado para o Egito?",
      options = listOf("Benjamim", "José", "Rúben", "Levi"),
      correctOptionIndex = 1,
      biblicalReference = "Gênesis 37:28",
      explanation = "José foi vendido aos ismaelitas e levado cativo ao Egito, onde mais tarde tornou-se governador.",
      difficulty = QuizDifficulty.FACIL,
      category = QuizCategory.PERSONAGENS
    ),
    QuizQuestion(
      id = 24,
      question = "Qual profeta foi arrebatado ao céu num redemoinho com carruagem de fogo?",
      options = listOf("Elias", "Eliseu", "Samuel", "Isaías"),
      correctOptionIndex = 0,
      biblicalReference = "2 Reis 2:11",
      explanation = "Um carro de fogo com cavalos de fogo separou Elias e Eliseu, e Elias subiu ao céu num redemoinho.",
      difficulty = QuizDifficulty.FACIL,
      category = QuizCategory.PROFETAS
    ),
    QuizQuestion(
      id = 25,
      question = "Quem perdeu suas forças após ter seus cabelos cortados?",
      options = listOf("Gideão", "Sansão", "Saul", "Absalão"),
      correctOptionIndex = 1,
      biblicalReference = "Juízes 16:19",
      explanation = "Sansão era nazireu de Deus e a navalha nunca havia passado em sua cabeça.",
      difficulty = QuizDifficulty.FACIL,
      category = QuizCategory.PERSONAGENS
    ),
    QuizQuestion(
      id = 26,
      question = "Em quantas partes foi dividido o rio Jordão quando a arca da aliança tocou a água?",
      options = listOf("Não se dividiu", "As águas pararam e o povo passou a pé enxuto", "Dividiu-se em três partes", "Criou uma ponte de pedra"),
      correctOptionIndex = 1,
      biblicalReference = "Josué 3:15-17",
      explanation = "Sob a liderança de Josué, as águas do Jordão se amontoaram para a passagem de Israel.",
      difficulty = QuizDifficulty.MEDIO,
      category = QuizCategory.MILAGRES_E_PARABOLAS
    ),
    QuizQuestion(
      id = 27,
      question = "Quantas pragas Deus enviou sobre a terra do Egito?",
      options = listOf("7", "10", "12", "14"),
      correctOptionIndex = 1,
      biblicalReference = "Êxodo 7 a 12",
      explanation = "Foram dez pragas no Egito, terminando com a morte dos primogênitos e a instituição da Páscoa.",
      difficulty = QuizDifficulty.FACIL,
      category = QuizCategory.ANTIGO_TESTAMENTO
    ),
    QuizQuestion(
      id = 28,
      question = "Qual casal morreu instantaneamente por mentir ao Espírito Santo em Atos?",
      options = listOf("Áquila e Priscila", "Ananias e Safira", "Zacarias e Isabel", "Elimeleque e Noemi"),
      correctOptionIndex = 1,
      biblicalReference = "Atos 5:1-10",
      explanation = "Ananias e Safira retiveram parte do valor de uma herdade e mentiram a Pedro e ao Espírito Santo.",
      difficulty = QuizDifficulty.MEDIO,
      category = QuizCategory.NOVO_TESTAMENTO
    ),
    QuizQuestion(
      id = 29,
      question = "Quem subiu numa figueira brava (sicômoro) para conseguir enxergar Jesus passar?",
      options = listOf("Bartimeu", "Zaqueu", "Nicodemos", "Simão fariseu"),
      correctOptionIndex = 1,
      biblicalReference = "Lucas 19:1-4",
      explanation = "Zaqueu, homem de pequena estatura e maioral dos publicanos, subiu no sicômoro.",
      difficulty = QuizDifficulty.FACIL,
      category = QuizCategory.EVANGELHOS
    ),
    QuizQuestion(
      id = 30,
      question = "Qual rainha judia arriscou a própria vida para salvar seu povo do decreto de Hamã?",
      options = listOf("Rute", "Ester", "Débora", "Vasti"),
      correctOptionIndex = 1,
      biblicalReference = "Ester 4:16; 7:3",
      explanation = "A rainha Ester declarou: 'Se perecer, pereci' e intercedeu diante do rei Assuero.",
      difficulty = QuizDifficulty.FACIL,
      category = QuizCategory.PERSONAGENS
    ),
    QuizQuestion(
      id = 31,
      question = "Quem era a sogra amorosa de Rute no livro bíblico que leva seu nome?",
      options = listOf("Ana", "Noemi", "Sara", "Orfa"),
      correctOptionIndex = 1,
      biblicalReference = "Rute 1:16",
      explanation = "Rute disse a Noemi: 'O teu povo é o meu povo, e o teu Deus é o meu Deus'.",
      difficulty = QuizDifficulty.FACIL,
      category = QuizCategory.PERSONAGENS
    ),
    QuizQuestion(
      id = 32,
      question = "Qual profeta orou e não choveu por três anos e seis meses?",
      options = listOf("Isaías", "Elias", "Eliseu", "Miqueias"),
      correctOptionIndex = 1,
      biblicalReference = "1 Reis 17:1; Tiago 5:17",
      explanation = "Elias orou fervorosamente e não choveu na terra durante três anos e seis meses.",
      difficulty = QuizDifficulty.MEDIO,
      category = QuizCategory.PROFETAS
    ),
    QuizQuestion(
      id = 33,
      question = "Quem interpretou os sonhos do Faraó sobre as sete vacas gordas e sete magras?",
      options = listOf("Moisés", "Daniel", "José", "Gideão"),
      correctOptionIndex = 2,
      biblicalReference = "Gênesis 41:25-30",
      explanation = "Deus revelou a José a interpretação dos sete anos de fartura e sete de fome.",
      difficulty = QuizDifficulty.FACIL,
      category = QuizCategory.PERSONAGENS
    ),
    QuizQuestion(
      id = 34,
      question = "Quem foi a primeira mulher juíza e profetisa mencionada no livro de Juízes?",
      options = listOf("Débora", "Jael", "Dalila", "Miriã"),
      correctOptionIndex = 0,
      biblicalReference = "Juízes 4:4",
      explanation = "Débora, mulher de Lapidote, julgava a Israel naquele tempo debaixo da palmeira.",
      difficulty = QuizDifficulty.MEDIO,
      category = QuizCategory.PERSONAGENS
    ),
    QuizQuestion(
      id = 35,
      question = "Qual apóstolo era cobrador de impostos (publicano) antes de seguir a Jesus?",
      options = listOf("Pedro", "Mateus (Levi)", "João", "Judas Tadeu"),
      correctOptionIndex = 1,
      biblicalReference = "Mateus 9:9",
      explanation = "Jesus viu Mateus assentado na coletoria e disse-lhe: 'Segue-me'.",
      difficulty = QuizDifficulty.FACIL,
      category = QuizCategory.EVANGELHOS
    ),
    QuizQuestion(
      id = 36,
      question = "Quantas vezes Naamã, o capitão sírio, teve que mergulhar no Jordão para ser curado da lepra?",
      options = listOf("3 vezes", "5 vezes", "7 vezes", "10 vezes"),
      correctOptionIndex = 2,
      biblicalReference = "2 Reis 5:14",
      explanation = "Naamã mergulhou sete vezes no Jordão e sua carne tornou-se limpa como a de um menino.",
      difficulty = QuizDifficulty.FACIL,
      category = QuizCategory.MILAGRES_E_PARABOLAS
    ),
    QuizQuestion(
      id = 37,
      question = "Em qual dia da Criação Deus criou o sol, a lua e as estrelas?",
      options = listOf("Primeiro dia", "Terceiro dia", "Quarto dia", "Sexto dia"),
      correctOptionIndex = 2,
      biblicalReference = "Gênesis 1:14-19",
      explanation = "No quarto dia, Deus fez os dois grandes luminares e as estrelas nos céus.",
      difficulty = QuizDifficulty.MEDIO,
      category = QuizCategory.ANTIGO_TESTAMENTO
    ),
    QuizQuestion(
      id = 38,
      question = "Qual líder hebreu fez as muralhas de Jericó caírem após rodear a cidade por sete dias?",
      options = listOf("Calebe", "Josué", "Gideão", "Jefté"),
      correctOptionIndex = 1,
      biblicalReference = "Josué 6:20",
      explanation = "Ao som das buzinas e ao clamor do povo liderado por Josué, o muro ruiu.",
      difficulty = QuizDifficulty.FACIL,
      category = QuizCategory.ANTIGO_TESTAMENTO
    ),
    QuizQuestion(
      id = 39,
      question = "O que caiu do céu para alimentar o povo de Israel no deserto?",
      options = listOf("Pão de figos", "Maná", "Trigo tostado", "Olivas"),
      correctOptionIndex = 1,
      biblicalReference = "Êxodo 16:15",
      explanation = "O maná caía como orvalho pela manhã e sustentou Israel durante quarenta anos.",
      difficulty = QuizDifficulty.FACIL,
      category = QuizCategory.ANTIGO_TESTAMENTO
    ),
    QuizQuestion(
      id = 40,
      question = "Qual livro bíblico é famoso pelo versículo: 'Tudo tem o seu tempo determinado'?",
      options = listOf("Provérbios", "Eclesiastes", "Cânticos", "Salmos"),
      correctOptionIndex = 1,
      biblicalReference = "Eclesiastes 3:1",
      explanation = "Eclesiastes capítulo 3 ensina sobre o tempo oportuno para cada propósito debaixo do céu.",
      difficulty = QuizDifficulty.FACIL,
      category = QuizCategory.ANTIGO_TESTAMENTO
    ),
    QuizQuestion(
      id = 41,
      question = "Com quantos pães e peixinhos Jesus alimentou uma multidão de quase 5 mil homens?",
      options = listOf("3 pães e 2 peixes", "5 pães e 2 peixinhos", "7 pães e 4 peixes", "12 pães e 1 peixe"),
      correctOptionIndex = 1,
      biblicalReference = "João 6:9",
      explanation = "Um rapaz trazia cinco pães de cevada e dois peixinhos, que Jesus multiplicou.",
      difficulty = QuizDifficulty.FACIL,
      category = QuizCategory.MILAGRES_E_PARABOLAS
    ),
    QuizQuestion(
      id = 42,
      question = "Quem foi o primeiro mártir cristão apedrejado até a morte registrado em Atos?",
      options = listOf("Estêvão", "Filipe", "Tiago irmão de João", "Barnabé"),
      correctOptionIndex = 0,
      biblicalReference = "Atos 7:59-60",
      explanation = "Estêvão, cheio do Espírito Santo, perdoou seus agressores enquanto era apedrejado.",
      difficulty = QuizDifficulty.MEDIO,
      category = QuizCategory.NOVO_TESTAMENTO
    ),
    QuizQuestion(
      id = 43,
      question = "Qual era a profissão de Paulo além de pregar o Evangelho?",
      options = listOf("Pescador", "Fabricante de tendas", "Carpinteiro", "Médico"),
      correctOptionIndex = 1,
      biblicalReference = "Atos 18:3",
      explanation = "Paulo exercia o ofício de fabricante de tendas junto de Áquila e Priscila.",
      difficulty = QuizDifficulty.MEDIO,
      category = QuizCategory.NOVO_TESTAMENTO
    ),
    QuizQuestion(
      id = 44,
      question = "Quem escreveu o Evangelho que leva seu nome e também o livro de Atos dos Apóstolos?",
      options = listOf("Marcos", "Lucas", "Mateus", "João"),
      correctOptionIndex = 1,
      biblicalReference = "Lucas 1:1-4; Atos 1:1",
      explanation = "Lucas, o médico amado, escreveu tanto o Evangelho como o livro de Atos a Teófilo.",
      difficulty = QuizDifficulty.MEDIO,
      category = QuizCategory.NOVO_TESTAMENTO
    ),
    QuizQuestion(
      id = 45,
      question = "Em qual caminho Saulo de Tarso teve um encontro com a luz resplandecente de Jesus?",
      options = listOf("Caminho de Jericó", "Caminho de Emaús", "Caminho de Damasco", "Caminho de Gaza"),
      correctOptionIndex = 2,
      biblicalReference = "Atos 9:3-5",
      explanation = "Indo a Damasco com cartas de perseguição, Saulo ouviu a voz do Senhor.",
      difficulty = QuizDifficulty.FACIL,
      category = QuizCategory.NOVO_TESTAMENTO
    ),
    QuizQuestion(
      id = 46,
      question = "Qual é o fruto do Espírito mencionado em Gálatas 5 que começa com Amor?",
      options = listOf("Fama e poder", "Amor, gozo, paz, longanimidade, benignidade, bondade, fé, mansidão, temperança", "Riqueza e sucesso", "Força e beleza"),
      correctOptionIndex = 1,
      biblicalReference = "Gálatas 5:22-23",
      explanation = "O fruto do Espírito reúne as nove virtudes celestiais concedidas pela graça.",
      difficulty = QuizDifficulty.FACIL,
      category = QuizCategory.NOVO_TESTAMENTO
    ),
    QuizQuestion(
      id = 47,
      question = "Quem orou no ventre de uma baleia/peixe durante três dias?",
      options = listOf("Moisés", "Jonas", "Noé", "Abraão"),
      correctOptionIndex = 1,
      biblicalReference = "Jonas 2:1",
      explanation = "Do ventre do grande peixe, Jonas clamou com voz de louvor ao Senhor.",
      difficulty = QuizDifficulty.FACIL,
      category = QuizCategory.PROFETAS
    ),
    QuizQuestion(
      id = 48,
      question = "Quem foi escolhido para substituir Judas Iscariotes entre os doze apóstolos?",
      options = listOf("Barnabé", "Matias", "Silas", "Timóteo"),
      correctOptionIndex = 1,
      biblicalReference = "Atos 1:26",
      explanation = "Lançando sortes em oração, a sorte caiu sobre Matias, que foi contado com os onze.",
      difficulty = QuizDifficulty.MEDIO,
      category = QuizCategory.NOVO_TESTAMENTO
    ),
    QuizQuestion(
      id = 49,
      question = "Qual profeta viu um vale cheio de ossos secos reviverem pelo sopro do Espírito?",
      options = listOf("Jeremias", "Ezequiel", "Daniel", "Oséias"),
      correctOptionIndex = 1,
      biblicalReference = "Ezequiel 37:1-10",
      explanation = "O Senhor levou Ezequiel a profetizar ao vento para que os ossos secos tivessem vida.",
      difficulty = QuizDifficulty.MEDIO,
      category = QuizCategory.PROFETAS
    ),
    QuizQuestion(
      id = 50,
      question = "Qual animal falou com o profeta Balaão após ver o anjo do Senhor com espada desembainhada?",
      options = listOf("Uma ovelha", "Uma jumenta", "Um camelo", "Um leão"),
      correctOptionIndex = 1,
      biblicalReference = "Números 22:28-30",
      explanation = "O Senhor abriu a boca da jumenta, repreendendo a loucura de Balaão.",
      difficulty = QuizDifficulty.FACIL,
      category = QuizCategory.ANTIGO_TESTAMENTO
    ),
    QuizQuestion(
      id = 51,
      question = "Qual homem viveu o maior número de anos registrado na Bíblia (969 anos)?",
      options = listOf("Adão", "Noé", "Matusalém", "Enos"),
      correctOptionIndex = 2,
      biblicalReference = "Gênesis 5:27",
      explanation = "Matusalém viveu 969 anos antes de falecer.",
      difficulty = QuizDifficulty.FACIL,
      category = QuizCategory.PERSONAGENS
    ),
    QuizQuestion(
      id = 52,
      question = "Quem andou com Deus e não viu a morte, porque Deus o tomou para Si?",
      options = listOf("Enoque", "Lameque", "Sete", "Melquisedeque"),
      correctOptionIndex = 0,
      biblicalReference = "Gênesis 5:24; Hebreus 11:5",
      explanation = "Enoque andou com Deus; e não se viu mais, porque Deus para Si o tomou.",
      difficulty = QuizDifficulty.MEDIO,
      category = QuizCategory.PERSONAGENS
    ),
    QuizQuestion(
      id = 53,
      question = "Qual era o nome da esposa de Abraão que deu à luz Isaque na velhice?",
      options = listOf("Rebeca", "Sara", "Raquel", "Lia"),
      correctOptionIndex = 1,
      biblicalReference = "Gênesis 21:1-3",
      explanation = "Sara concebeu e deu à luz a Isaque quando Abraão já tinha 100 anos de idade.",
      difficulty = QuizDifficulty.FACIL,
      category = QuizCategory.PERSONAGENS
    ),
    QuizQuestion(
      id = 54,
      question = "Qual dos filhos de Jacó recebeu a bênção da linhagem real do cetro?",
      options = listOf("Rúben", "Judá", "Dã", "Gade"),
      correctOptionIndex = 1,
      biblicalReference = "Gênesis 49:10",
      explanation = "O cetro não se arredará de Judá, nem o legislador dentre seus pés, até que venha Siló.",
      difficulty = QuizDifficulty.MEDIO,
      category = QuizCategory.ANTIGO_TESTAMENTO
    ),
    QuizQuestion(
      id = 55,
      question = "Qual povo caminhou no deserto sem que suas roupas e calçados envelhecessem?",
      options = listOf("Os filisteus", "Os edomitas", "Os israelitas", "Os moabitas"),
      correctOptionIndex = 2,
      biblicalReference = "Deuteronômio 29:5",
      explanation = "Durante quarenta anos no deserto, os vestidos e calçados do povo não se gastaram.",
      difficulty = QuizDifficulty.MEDIO,
      category = QuizCategory.ANTIGO_TESTAMENTO
    ),
    QuizQuestion(
      id = 56,
      question = "Quem era o sacerdote e mentor do jovem profeta Samuel em Siló?",
      options = listOf("Eli", "Finéias", "Aitofel", "Zadoque"),
      correctOptionIndex = 0,
      biblicalReference = "1 Samuel 3:1-9",
      explanation = "O sacerdote Eli ensinou o menino Samuel a responder: 'Fala, Senhor, porque o teu servo ouve'.",
      difficulty = QuizDifficulty.FACIL,
      category = QuizCategory.PERSONAGENS
    ),
    QuizQuestion(
      id = 57,
      question = "Quem foi o primeiro rei de todo o reino de Israel?",
      options = listOf("Davi", "Saul", "Salomão", "Roboão"),
      correctOptionIndex = 1,
      biblicalReference = "1 Samuel 10:1",
      explanation = "Saul, filho de Quis, da tribo de Benjamim, foi o primeiro rei ungido por Samuel.",
      difficulty = QuizDifficulty.FACIL,
      category = QuizCategory.PROFETAS
    ),
    QuizQuestion(
      id = 58,
      question = "Qual amigo fiel fez aliança de amor fraternal com Davi arriscando a ira de seu pai Saul?",
      options = listOf("Jônatas", "Abner", "Joabe", "Hussai"),
      correctOptionIndex = 0,
      biblicalReference = "1 Samuel 18:1-3",
      explanation = "A alma de Jônatas se ligou com a alma de Davi, amando-o como à sua própria vida.",
      difficulty = QuizDifficulty.FACIL,
      category = QuizCategory.PERSONAGENS
    ),
    QuizQuestion(
      id = 59,
      question = "Qual profeta repreendeu o rei Davi usando uma parábola sobre uma cordeirinha?",
      options = listOf("Gade", "Natã", "Aías", "Micaías"),
      correctOptionIndex = 1,
      biblicalReference = "2 Samuel 12:1-7",
      explanation = "O profeta Natã disse a Davi: 'Tu és este homem!', levando o rei ao arrependimento.",
      difficulty = QuizDifficulty.MEDIO,
      category = QuizCategory.PROFETAS
    ),
    QuizQuestion(
      id = 60,
      question = "Qual mulher inteligente impediu Davi de cometer derramamento de sangue contra o insensato Nabal?",
      options = listOf("Abigail", "Bate-Seba", "Mical", "Tamar"),
      correctOptionIndex = 0,
      biblicalReference = "1 Samuel 25:23-35",
      explanation = "Abigail levou provisões e com humildade e sabedoria intercedeu pela sua casa.",
      difficulty = QuizDifficulty.MEDIO,
      category = QuizCategory.PERSONAGENS
    ),
    QuizQuestion(
      id = 61,
      question = "Quem construiu o primeiro grande Templo do Senhor em Jerusalém?",
      options = listOf("Davi", "Salomão", "Zorobabel", "Neemias"),
      correctOptionIndex = 1,
      biblicalReference = "1 Reis 6:1",
      explanation = "Salomão edificou a majestosa casa do Senhor no quarto ano do seu reinado.",
      difficulty = QuizDifficulty.FACIL,
      category = QuizCategory.ANTIGO_TESTAMENTO
    ),
    QuizQuestion(
      id = 62,
      question = "No confronto no Monte Carmelo contra os 450 profetas de Baal, como Deus respondeu à oração de Elias?",
      options = listOf("Com um terremoto", "Com fogo do céu que consumiu o holocausto e a água", "Com chuva torrencial imediata", "Com um vendaval"),
      correctOptionIndex = 1,
      biblicalReference = "1 Reis 18:38",
      explanation = "O fogo do Senhor desceu e consumiu o sacrifício, a lenha, as pedras e lambeu a água na vala.",
      difficulty = QuizDifficulty.FACIL,
      category = QuizCategory.MILAGRES_E_PARABOLAS
    ),
    QuizQuestion(
      id = 63,
      question = "Quantos milagres Eliseu realizou em relação a Elias segundo o registro bíblico tradicional?",
      options = listOf("Menos da metade", "Exatamente o mesmo número", "O dobro (porção dobrada)", "Apenas dois"),
      correctOptionIndex = 2,
      biblicalReference = "2 Reis 2:9",
      explanation = "Eliseu pediu: 'Peço-te que haja porção dobrada do teu espírito sobre mim' e recebeu.",
      difficulty = QuizDifficulty.MEDIO,
      category = QuizCategory.PROFETAS
    ),
    QuizQuestion(
      id = 64,
      question = "Qual rei piedoso de Judá viu Deus acrescentar 15 anos à sua vida após orar e chorar?",
      options = listOf("Josias", "Ezequias", "Asa", "Josafá"),
      correctOptionIndex = 1,
      biblicalReference = "2 Reis 20:5-6",
      explanation = "Deus ouviu o clamor de Ezequias e acrescentou quinze anos aos seus dias.",
      difficulty = QuizDifficulty.MEDIO,
      category = QuizCategory.PROFETAS
    ),
    QuizQuestion(
      id = 65,
      question = "Quem liderou a reconstrução dos muros caídos de Jerusalém em apenas 52 dias?",
      options = listOf("Esdras", "Neemias", "Zorobabel", "Mardoqueu"),
      correctOptionIndex = 1,
      biblicalReference = "Neemias 6:15",
      explanation = "O copeiro do rei, Neemias, mobilizou o povo e concluiu o muro em 52 dias.",
      difficulty = QuizDifficulty.FACIL,
      category = QuizCategory.PERSONAGENS
    ),
    QuizQuestion(
      id = 66,
      question = "Qual servo sofredor perdeu filhos, gado e saúde, mas declarou: 'Eu sei que o meu Redentor vive'?",
      options = listOf("Jó", "Jeremias", "Habacuque", "Davi"),
      correctOptionIndex = 0,
      biblicalReference = "Jó 19:25",
      explanation = "Jó manteve sua esperança viva em Deus em meio às mais intensas aflições.",
      difficulty = QuizDifficulty.FACIL,
      category = QuizCategory.PERSONAGENS
    ),
    QuizQuestion(
      id = 67,
      question = "Qual capítulo do livro de Isaías descreve profeticamente o Messias como o 'Servo Sofredor' ferido pelas nossas transgressões?",
      options = listOf("Isaías 7", "Isaías 9", "Isaías 40", "Isaías 53"),
      correctOptionIndex = 3,
      biblicalReference = "Isaías 53:5",
      explanation = "Isaías 53 profetiza com precisão espantosa os sofrimentos e expiação de Cristo no Calvário.",
      difficulty = QuizDifficulty.MEDIO,
      category = QuizCategory.PROFETAS
    ),
    QuizQuestion(
      id = 68,
      question = "Qual profeta é conhecido nas Escrituras como o 'profeta chorão' devido às suas dores por Jerusalém?",
      options = listOf("Isaías", "Jeremias", "Amós", "Malaquias"),
      correctOptionIndex = 1,
      biblicalReference = "Jeremias 9:1; Lamentações",
      explanation = "Jeremias derramou lágrimas pela rebelião e cativeiro do povo de Judá.",
      difficulty = QuizDifficulty.FACIL,
      category = QuizCategory.PROFETAS
    ),
    QuizQuestion(
      id = 69,
      question = "Quem foram os três jovens hebreus jogados na fornalha ardente de fogo por não se dobrarem à estátua de ouro?",
      options = listOf("Sadraque, Mesaque e Abednego", "Pedro, Tiago e João", "Elifaz, Bildade e Zofar", "Nadabe, Abiú e Eleazar"),
      correctOptionIndex = 0,
      biblicalReference = "Daniel 3:19-25",
      explanation = "Na fornalha aquecida sete vezes mais, Nabucodonosor viu quatro homens soltos, e o quarto era semelhante ao Filho de Deus.",
      difficulty = QuizDifficulty.FACIL,
      category = QuizCategory.PROFETAS
    ),
    QuizQuestion(
      id = 70,
      question = "Qual foi o último profeta do Antigo Testamento?",
      options = listOf("Zacarias", "Ageu", "Malaquias", "Sofonias"),
      correctOptionIndex = 2,
      biblicalReference = "Malaquias 4",
      explanation = "Malaquias conclui a profecia do Antigo Testamento anunciando o precursor Elias.",
      difficulty = QuizDifficulty.FACIL,
      category = QuizCategory.PROFETAS
    ),
    QuizQuestion(
      id = 71,
      question = "Qual anjo anunciou à virgem Maria que ela conceberia o Salvador por obra do Espírito Santo?",
      options = listOf("Miguel", "Gabriel", "Rafael", "Uriel"),
      correctOptionIndex = 1,
      biblicalReference = "Lucas 1:26-31",
      explanation = "O anjo Gabriel foi enviado por Deus à cidade de Nazaré para anunciar a encarnação de Jesus.",
      difficulty = QuizDifficulty.FACIL,
      category = QuizCategory.EVANGELHOS
    ),
    QuizQuestion(
      id = 72,
      question = "O que os magos do Oriente trouxeram de presente ao menino Jesus?",
      options = listOf("Trigo, azeite e figos", "Ouro, incenso e mirra", "Prata, pedras e sedas", "Vinho, pão e pérolas"),
      correctOptionIndex = 1,
      biblicalReference = "Mateus 2:11",
      explanation = "Os presentes proféticos simbolizavam Sua realeza (ouro), divindade (incenso) e sacrifício mortal (mirra).",
      difficulty = QuizDifficulty.FACIL,
      category = QuizCategory.EVANGELHOS
    ),
    QuizQuestion(
      id = 73,
      question = "Em qual discurso Jesus pronunciou as famosas 'Bem-aventuranças'?",
      options = listOf("Sermão do Monte", "Sermão Profético", "Discurso no Cenáculo", "Discurso no Areópago"),
      correctOptionIndex = 0,
      biblicalReference = "Mateus 5:1-12",
      explanation = "No Sermão da Montanha, Jesus proclamou as bênçãos para os humildes de espírito e pacificadores.",
      difficulty = QuizDifficulty.FACIL,
      category = QuizCategory.EVANGELHOS
    ),
    QuizQuestion(
      id = 74,
      question = "Na parábola do Filho Pródigo, o que o pai fez quando viu o filho voltando de longe?",
      options = listOf("Trancou as portas", "Correu, abraçou-o e o beijou", "Exigiu que pagasse a dívida", "Mandou-o para os servos"),
      correctOptionIndex = 1,
      biblicalReference = "Lucas 15:20",
      explanation = "Movido de compaixão, o pai correu ao seu encontro, lançou-se-lhe ao pescoço e o beijou.",
      difficulty = QuizDifficulty.FACIL,
      category = QuizCategory.MILAGRES_E_PARABOLAS
    ),
    QuizQuestion(
      id = 75,
      question = "Quem socorreu o homem ferido pelos salteadores na parábola contada por Jesus em Lucas 10?",
      options = listOf("O sacerdote", "O levita", "O bom samaritano", "O soldado romano"),
      correctOptionIndex = 2,
      biblicalReference = "Lucas 10:33-35",
      explanation = "Um samaritano que ia de viagem, vendo-o, moveu-se de íntima compaixão e cuidou de suas feridas.",
      difficulty = QuizDifficulty.FACIL,
      category = QuizCategory.MILAGRES_E_PARABOLAS
    ),
    QuizQuestion(
      id = 76,
      question = "Qual mulher lavou os pés de Jesus com suas lágrimas e os enxugou com os seus cabelos?",
      options = listOf("Marta", "A mulher pecadora que levou um vaso de alabastro", "Salomé", "Dorcas"),
      correctOptionIndex = 1,
      biblicalReference = "Lucas 7:37-38",
      explanation = "Em casa do fariseu Simão, a mulher ungiu os pés de Jesus em profunda reverência e amor.",
      difficulty = QuizDifficulty.MEDIO,
      category = QuizCategory.EVANGELHOS
    ),
    QuizQuestion(
      id = 77,
      question = "Quem andou sobre as águas em direção a Jesus antes de ter medo e começar a afundar?",
      options = listOf("João", "Pedro", "Tiago", "André"),
      correctOptionIndex = 1,
      biblicalReference = "Mateus 14:28-31",
      explanation = "Pedro desceu do barco e andou sobre as águas, mas reparando no vento forte, temeu e clamou: 'Senhor, salva-me!'.",
      difficulty = QuizDifficulty.FACIL,
      category = QuizCategory.MILAGRES_E_PARABOLAS
    ),
    QuizQuestion(
      id = 78,
      question = "Qual governador romano lavou as mãos perante a multidão condenando Jesus à crucificação?",
      options = listOf("Herodes Antipas", "Pôncio Pilatos", "Félix", "Festos"),
      correctOptionIndex = 1,
      biblicalReference = "Mateus 27:24",
      explanation = "Pilatos lavou as mãos dizendo: 'Estou inocente do sangue deste justo; considerai isso vós'.",
      difficulty = QuizDifficulty.FACIL,
      category = QuizCategory.EVANGELHOS
    ),
    QuizQuestion(
      id = 79,
      question = "Qual foi a primeira pessoa a ver Jesus ressuscitado no jardim junto ao sepulcro?",
      options = listOf("Pedro", "Maria Madalena", "João", "Mãe de Jesus"),
      correctOptionIndex = 1,
      biblicalReference = "João 20:14-16; Marcos 16:9",
      explanation = "Jesus apareceu primeiro a Maria Madalena, chamando-a pelo nome: 'Maria!'.",
      difficulty = QuizDifficulty.FACIL,
      category = QuizCategory.EVANGELHOS
    ),
    QuizQuestion(
      id = 80,
      question = "Em qual festa judaica o Espírito Santo desceu como línguas repartidas de fogo sobre os discípulos?",
      options = listOf("Páscoa", "Pentecostes", "Tabernáculos", "Purim"),
      correctOptionIndex = 1,
      biblicalReference = "Atos 2:1-4",
      explanation = "Cumprindo-se o dia de Pentecostes, todos foram cheios do Espírito Santo e falaram noutras línguas.",
      difficulty = QuizDifficulty.FACIL,
      category = QuizCategory.NOVO_TESTAMENTO
    ),
    QuizQuestion(
      id = 81,
      question = "Quem curou um coxo de nascença na Porta Formosa do Templo dizendo: 'Não tenho prata nem ouro, mas o que tenho te dou'?",
      options = listOf("Pedro e João", "Paulo e Barnabé", "Filipe e Estêvão", "Tiago e Judas"),
      correctOptionIndex = 0,
      biblicalReference = "Atos 3:6",
      explanation = "Pedro disse: 'Em nome de Jesus Cristo, o Nazareno, levanta-te e anda!'.",
      difficulty = QuizDifficulty.FACIL,
      category = QuizCategory.NOVO_TESTAMENTO
    ),
    QuizQuestion(
      id = 82,
      question = "Qual centurião romano foi o primeiro gentio a receber o Evangelho na casa dele através de Pedro?",
      options = listOf("Júlio", "Cornélio", "Cláudio Lísias", "Sérgio Paulo"),
      correctOptionIndex = 1,
      biblicalReference = "Atos 10:1-48",
      explanation = "Cornélio era piedoso e temente a Deus com toda a sua casa, e o Espírito desceu sobre todos.",
      difficulty = QuizDifficulty.MEDIO,
      category = QuizCategory.NOVO_TESTAMENTO
    ),
    QuizQuestion(
      id = 83,
      question = "O que aconteceu à meia-noite na prisão de Filipos quando Paulo e Silas cantavam louvores a Deus?",
      options = listOf("Veio um sono pesado sobre todos", "Um grande terremoto abriu as portas e soltou as prisões", "Os guardas fugiram", "Uma enchente inundou a cela"),
      correctOptionIndex = 1,
      biblicalReference = "Atos 16:25-26",
      explanation = "Houve um terremoto tão grande que os alicerces tremeram e as correntes se soltaram.",
      difficulty = QuizDifficulty.FACIL,
      category = QuizCategory.MILAGRES_E_PARABOLAS
    ),
    QuizQuestion(
      id = 84,
      question = "Em 1 Coríntios 13, qual é considerada a maior de todas as virtudes eternas?",
      options = listOf("A fé", "A esperança", "O amor (caridade)", "O conhecimento"),
      correctOptionIndex = 2,
      biblicalReference = "1 Coríntios 13:13",
      explanation = "Agora permanecem a fé, a esperança e o amor; porém o maior destes é o amor.",
      difficulty = QuizDifficulty.FACIL,
      category = QuizCategory.NOVO_TESTAMENTO
    ),
    QuizQuestion(
      id = 85,
      question = "O que a armadura de Deus em Efésios 6 identifica como 'a espada do Espírito'?",
      options = listOf("A caridade", "A Palavra de Deus", "O escudo da fé", "O capacete da salvação"),
      correctOptionIndex = 1,
      biblicalReference = "Efésios 6:17",
      explanation = "Tomai também o capacete da salvação e a espada do Espírito, que é a palavra de Deus.",
      difficulty = QuizDifficulty.MEDIO,
      category = QuizCategory.NOVO_TESTAMENTO
    ),
    QuizQuestion(
      id = 86,
      question = "Em Hebreus 11:1, qual é a definição sagrada de fé?",
      options = listOf("Sentimento de alegria", "O firme fundamento das coisas que se esperam, e a prova das coisas que se não veem", "Conhecimento racional de teologia", "Desejo humano positivo"),
      correctOptionIndex = 1,
      biblicalReference = "Hebreus 11:1",
      explanation = "A fé é a substância viva da nossa esperança eterna nas promessas divinas.",
      difficulty = QuizDifficulty.MEDIO,
      category = QuizCategory.NOVO_TESTAMENTO
    ),
    QuizQuestion(
      id = 87,
      question = "Em qual ilha o apóstolo João estava exilado quando recebeu as visões do Apocalipse?",
      options = listOf("Chipre", "Creta", "Patmos", "Malta"),
      correctOptionIndex = 2,
      biblicalReference = "Apocalipse 1:9",
      explanation = "João estava na ilha chamada Patmos por causa da palavra de Deus e do testemunho de Jesus.",
      difficulty = QuizDifficulty.MEDIO,
      category = QuizCategory.NOVO_TESTAMENTO
    ),
    QuizQuestion(
      id = 88,
      question = "Quantas portas de pérola possui a Nova Jerusalém descrita em Apocalipse 21?",
      options = listOf("3", "7", "12", "24"),
      correctOptionIndex = 2,
      biblicalReference = "Apocalipse 21:12-21",
      explanation = "Tinha doze portas e nas portas doze anjos, com os nomes das doze tribos dos filhos de Israel.",
      difficulty = QuizDifficulty.MEDIO,
      category = QuizCategory.NOVO_TESTAMENTO
    ),
    QuizQuestion(
      id = 89,
      question = "Quem foi a mãe do profeta Samuel que orou com amargura de alma pedindo um filho?",
      options = listOf("Penina", "Ana", "Rebeca", "Hagar"),
      correctOptionIndex = 1,
      biblicalReference = "1 Samuel 1:10-20",
      explanation = "Ana orou e chorou abundantemente diante do Senhor, e Deus lembrou-Se dela dando-lhe Samuel.",
      difficulty = QuizDifficulty.FACIL,
      category = QuizCategory.PERSONAGENS
    ),
    QuizQuestion(
      id = 90,
      question = "Qual líder militar pediu a Deus uma prova com o velo de lã molhado pelo orvalho?",
      options = listOf("Gideão", "Baraque", "Jefté", "Sansão"),
      correctOptionIndex = 0,
      biblicalReference = "Juízes 6:36-40",
      explanation = "Gideão pediu o sinal do velo de lã para confirmar que Deus livraria Israel por sua mão.",
      difficulty = QuizDifficulty.MEDIO,
      category = QuizCategory.PERSONAGENS
    ),
    QuizQuestion(
      id = 91,
      question = "Com quantos homens escolhidos Gideão venceu o vasto exército dos midianitas?",
      options = listOf("32.000", "10.000", "300", "70"),
      correctOptionIndex = 2,
      biblicalReference = "Juízes 7:7",
      explanation = "Deus reduziu o exército a apenas 300 homens que lamberam a água como cães para que a glória fosse só de Deus.",
      difficulty = QuizDifficulty.FACIL,
      category = QuizCategory.MILAGRES_E_PARABOLAS
    ),
    QuizQuestion(
      id = 92,
      question = "Quem caiu da janela no terceiro andar após adormecer durante a longa pregação de Paulo em Trôade?",
      options = listOf("Êutico", "Tíquico", "Erasto", "Trofimo"),
      correctOptionIndex = 0,
      biblicalReference = "Atos 20:9-10",
      explanation = "Êutico adormeceu profundamente, caiu e foi levantado morto, mas Paulo o abraçou e sua alma voltou a ele.",
      difficulty = QuizDifficulty.DIFICIL,
      category = QuizCategory.NOVO_TESTAMENTO
    ),
    QuizQuestion(
      id = 93,
      question = "Qual era o nome do mendigo coberto de chagas que jazia à porta do rico em Lucas 16?",
      options = listOf("Bartimeu", "Lázaro", "Simão", "Zaqueu"),
      correctOptionIndex = 1,
      biblicalReference = "Lucas 16:20",
      explanation = "Lázaro morreu e foi levado pelos anjos para o seio de Abraão.",
      difficulty = QuizDifficulty.MEDIO,
      category = QuizCategory.MILAGRES_E_PARABOLAS
    ),
    QuizQuestion(
      id = 94,
      question = "Quantas pedras lisas Davi escolheu no ribeiro para enfrentar Golias?",
      options = listOf("1 pedra", "3 pedras", "5 pedras", "7 pedras"),
      correctOptionIndex = 2,
      biblicalReference = "1 Samuel 17:40",
      explanation = "Davi escolheu para si cinco pedras lisas do ribeiro e as pôs no alforje de pastor.",
      difficulty = QuizDifficulty.FACIL,
      category = QuizCategory.ANTIGO_TESTAMENTO
    ),
    QuizQuestion(
      id = 95,
      question = "Qual árvore Zaqueu subiu para ver passar o Messias?",
      options = listOf("Oliveira", "Cedro do Líbano", "Sicômoro (figueira brava)", "Carvalho"),
      correctOptionIndex = 2,
      biblicalReference = "Lucas 19:4",
      explanation = "Correndo adiante, subiu a uma figueira brava (sicômoro) para o ver.",
      difficulty = QuizDifficulty.MEDIO,
      category = QuizCategory.EVANGELHOS
    ),
    QuizQuestion(
      id = 96,
      question = "Qual pássaro Noé soltou da arca que voltou com uma folha de oliveira no bico?",
      options = listOf("Um corvo", "Uma pomba", "Uma andorinha", "Uma águia"),
      correctOptionIndex = 1,
      biblicalReference = "Gênesis 8:11",
      explanation = "À tarde a pomba voltou trazendo no bico uma folha nova de oliveira, sinal de que as águas minguaram.",
      difficulty = QuizDifficulty.FACIL,
      category = QuizCategory.ANTIGO_TESTAMENTO
    ),
    QuizQuestion(
      id = 97,
      question = "Qual discípulo foi até a margem do lago pescar e tirou uma moeda da boca do primeiro peixe para pagar o tributo?",
      options = listOf("João", "Pedro", "André", "Mateus"),
      correctOptionIndex = 1,
      biblicalReference = "Mateus 17:27",
      explanation = "Jesus disse a Pedro: 'Lança o anzol, tira o primeiro peixe que subir, e abrindo-lhe a boca acharás um estáter'.",
      difficulty = QuizDifficulty.MEDIO,
      category = QuizCategory.MILAGRES_E_PARABOLAS
    ),
    QuizQuestion(
      id = 98,
      question = "Quem comprou o campo de Anatote mesmo estando em plena prisão antes da invasão babilônica como sinal de esperança futura?",
      options = listOf("Ezequiel", "Jeremias", "Baruque", "Misael"),
      correctOptionIndex = 1,
      biblicalReference = "Jeremias 32:9",
      explanation = "Jeremias comprou o campo de seu primo Hanamel como profecia de que casas e campos ainda seriam comprados na terra.",
      difficulty = QuizDifficulty.DIFICIL,
      category = QuizCategory.PROFETAS
    ),
    QuizQuestion(
      id = 99,
      question = "Quem foi a mulher que escondeu os dois espias hebreus em Jericó pendurando um cordão de escarlata em sua janela?",
      options = listOf("Rute", "Raabe", "Débora", "Bate-Seba"),
      correctOptionIndex = 1,
      biblicalReference = "Josué 2:1-21; Hebreus 11:31",
      explanation = "Pela fé, a prostituta Raabe não pereceu com os incrédulos ao acolher em paz os espias.",
      difficulty = QuizDifficulty.MEDIO,
      category = QuizCategory.PERSONAGENS
    ),
    QuizQuestion(
      id = 100,
      question = "Qual o nome do filho que Abraão teve com a serva Hagar?",
      options = listOf("Isaque", "Ismael", "Midiã", "Zinrã"),
      correctOptionIndex = 1,
      biblicalReference = "Gênesis 16:15",
      explanation = "Hagar deu à luz um filho a Abraão, e este chamou o seu nome Ismael.",
      difficulty = QuizDifficulty.FACIL,
      category = QuizCategory.PERSONAGENS
    )
  )
}
