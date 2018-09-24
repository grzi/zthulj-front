<template>
    <div>
        <SideNav v-bind:activeSection='"cv"'></SideNav>
        <TitleBar v-bind:sectionTitle='sectionTitle'></TitleBar>

        <div class="content">
            <div class="container">
                <div class="row"><h4><b>{{cv.name}}</b></h4></div>
                <div class="row"><h6>{{cv.status}}</h6></div>
                <div class="row">
                    <div class="col s12 m6">
                        <h3 class="center brown-text">
                            <font-awesome-icon icon="question"/>
                        </h3>
                        <h5 class="center">Présentation</h5>
                        <p class="light italic center">
                            {{cv.presentation}}
                        </p>
                    </div>

                    <div class="col s12 m6">
                        <h5>
                            <b>Intérêts techniques</b>
                        </h5>
                        <div v-for="skill in cv.skills" v-bind:key="skill.name" class='techSkill'>
                            <div class="techSkillName pink lighten-2">
                                <span class="skillDescr light">{{skill.name}}</span>
                            </div>
                            <div class="positionAbsolute top0 left0">
                                <div :class="'techSkillProgress  skillProgress_w' + skill.note">
                                    <div class="pink progressBar">&nbsp;</div>
                                </div>
                                <div class="clearBoth"></div>
                            </div>

                        </div>
                    </div>
                </div>
                <div class="separator"></div>
                <h5 class="title">
                    <b>Expériences</b>
                </h5>
                <div v-for="exp in cv.experiences" v-bind:key="exp.name">
                    <div class="col s12 m6 l4">
                        <div class="card white">
                            <div class="card-content">
                                <span><b>{{exp.name}}</b></span> -
                                <span class="pink-text">{{exp.enterprise}}</span> -
                                <span><i>{{exp.date}}</i></span>
                                <div class="light description">{{exp.description}}</div>
                                <div v-for="skill in exp.skills" v-bind:key="skill" class="chip">
                                    {{skill}}
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="separator"></div>
                <h5 class="title">
                    <b>Compétences techniques</b>
                </h5>
                <div v-for="skill in cv.techSkills" v-bind:key="skill" class="chip">
                    {{skill}}
                </div>
                <h5 class="title">
                    <b>Autres compétences</b>
                </h5>
                <div v-for="skill in cv.otherSkills" v-bind:key="skill" class="chip">
                    {{skill}}
                </div>
            </div>

        </div>

        <Footer></Footer>
    </div>

</template>

<script>
  import SideNav from '@/components/thulj/commons/SideNav.vue'
  import TitleBar from '@/components/thulj/commons/TitleBar.vue'
  import Footer from '@/components/thulj/commons/Footer.vue'

  export default {
    name: 'CurriculumVitae',
    components: {
      SideNav,
      Footer,
      TitleBar
    },
    created () {
      document.title = 'Mon CV - Thulj.fr'
    },
    mounted () {
      var progressBars = document.getElementsByClassName('progressBar')
      for (var i = 0; i < progressBars.length; i++) {
        progressBars[i].animate({width: ['0%', '100%']}, {duration: 1250, fill: 'forwards'})
      }
    },
    data: function () {
      return {
        sectionTitle: 'zThulj > à propos',
        cv: {
          name: 'Jérémy THULLIEZ',
          status: 'Consultant chez ZENIKA',
          presentation: 'Fort de plusieurs années d\'expérience dans le domaine du e-commerce, j\'ai eu la chance de trouver bla bla bla bla bla bla',
          skills: [
            {
              name: 'JAVA / Kotlin',
              note: 9
            },
            {
              name: 'Vue JS',
              note: 7
            }
          ],
          experiences: [
            {
              name: 'TEST Experience',
              enterprise: 'CGI France',
              date: 'Depuis 2018',
              description: 'GNA GNA GNA GNA GNA GNA GNA GNA GNA GNA',
              skills: ['dezdze', 'qsdqsdqs', 'dsdsfdsfdso']
            },
            {
              name: 'TEST Experience',
              enterprise: 'CGI France',
              date: 'Depuis 2018',
              description: 'GNA GNA GNA GNA GNA GNA GNA GNA GNA GNA',
              skills: ['dezdze', 'qsdqsdqs', 'dsdsfdsfdso']
            }
          ],
          techSkills: ['JAVA', 'C#', 'Kotlin'],
          otherSkills: ['Marketing']
        }
      }
    }
  }
</script>

<style scoped>
    .description {
        margin-top: 15px;
        margin-bottom: 15px;
    }

    .title {
        margin-bottom: 30px;
    }

    h6 {
        margin: -1.233rem 0 .46rem 0;
    }

    .techSkill {
        width: 100%;
        background: #EEE;
        margin-top: 10px;
        position: relative;
    }

    .techSkillName {
        width: 100px;
        padding: 5px;
        text-align: center;
        color: white;
        position: relative;
        z-index: 25
    }

    .techSkillProgress {
        float: left;
    }

    .techSkillNote {
        padding: 5px;
        text-align: right;
        color: #555;
        float: left;
        padding-right: 15px;
    }

    .skillProgressContainer {
        float: left;
    }

    .skillDescr {
        font-size: 14px;
    }

    .positionAbsolute {
        position: absolute;
        z-index: 5;
        width: 100%;
    }

    .skillProgress_w1 {
        width: 45%;
    }

    .skillProgress_w2 {
        width: 50%;
    }

    .skillProgress_w3 {
        width: 55%;
    }

    .skillProgress_w4 {
        width: 60%;
    }

    .skillProgress_w5 {
        width: 65%;
    }

    .skillProgress_w6 {
        width: 70%;
    }

    .skillProgress_w7 {
        width: 75%;
    }

    .skillProgress_w8 {
        width: 80%;
    }

    .skillProgress_w9 {
        width: 85%;
    }

    .skillProgress_w10 {
        width: 90%;
    }

    .top0 {
        top: 0;
    }

    .left0 {
        left: 0;
    }

    .skillNote_w1 {
        width: 55%;
    }

    .skillNote_w2 {
        width: 50%;
    }

    .skillNote_w3 {
        width: 45%;
    }

    .skillNote_w4 {
        width: 40%;
    }

    .skillNote_w5 {
        width: 35%;
    }

    .skillNote_w6 {
        width: 30%;
    }

    .skillNote_w7 {
        width: 25%;
    }

    .skillNote_w8 {
        width: 20%;
    }

    .skillNote_w9 {
        width: 15%;
    }

    .skillNote_w10 {
        width: 10%;
    }

    .progressBar {
        width: 0%;
        padding: 5px;
        padding-left: 0px;
        padding-right: 0px;
    }

    .separator {
        width: 40%;
        margin-left: 30%;
        height: 1px;
        border-bottom: 1px dashed lightgrey;
    }

    .experience {
        padding: 15px;
        background: white;
    }
    Footer{margin-top:25px;}
</style>
