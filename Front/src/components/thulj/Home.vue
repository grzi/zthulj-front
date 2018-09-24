<template>
    <div>
        <SideNav v-bind:activeSection='"home"'/>
        <TitleBar v-bind:sectionTitle='sectionTitle'/>
        <div class="content">
            <div class="container">

                <div class="row">

                    <div class="row"><h4><b>Derniers billets</b></h4></div>
                    Liste des derniers billets publiés sur le site, toutes catégories confondues :

                    <div class="row margin-top-20">
                        <Card v-for="card in cards" v-bind:card="card" v-bind:key="card.title"/>
                    </div>
                </div>

            </div>
        </div>
        <Footer/>
    </div>
</template>

<script>
    import SideNav from '@/components/thulj/commons/SideNav.vue'
    import TitleBar from '@/components/thulj/commons/TitleBar.vue'
    import Footer from '@/components/thulj/commons/Footer.vue'
    import Card from '@/components/thulj/commons/Card.vue'

    export default {
        name: 'Home',
        components: {
            Card,
            SideNav,
            Footer,
            TitleBar
        },
        created () {
            document.title = 'Zthulj blog - Accueil'
        },
        data: function () {
            return {
                sectionTitle: 'zThulj > Accueil',
                cards: [
                    {
                        title: 'Le site fait peau neuve !',
                        description: 'I am a very simple card. I am good at containing small bits of information. I am convenient because I require little markup to use effectively.',
                        publishDate: '27/08/2018',
                        icon: 'newspaper',
                        section: 'blog',
                        link: 'boyouboyuyou'
                    },
                    {
                        title: 'Le site fait peau neuve !',
                        description: 'I am a very simple card. I am good at containing small bits of information. I am convenient because I require little markup to use effectively.',
                        publishDate: '27/08/2018',
                        icon: 'newspaper',
                        section: 'blog',
                        link: 'areuhareuh'
                    },
                    {
                        title: 'Le site fait peau neuve !',
                        description: 'I am a very simple card. I am good at containing small bits of information. I am convenient because I require little markup to use effectively.',
                        publishDate: '27/08/2018',
                        icon: 'code',
                        section: 'projects',
                        link: 'dklzdjzlekdjzekljd'
                    },
                    {
                        title: 'Le site fait peau neuve !',
                        description: 'I am a very simple card. I am good at containing small bits of information. I am convenient because I require little markup to use effectively.',
                        publishDate: '27/08/2018',
                        icon: 'code',
                        section: 'projects',
                        link: 'straaaaaate'
                    }
                ]
            }
        }
    }
</script>

<style scoped>
    .margin-top-20 {
        margin-top: 20px;
    }

    #index-banner {
        background-image: url("../../assets/header.jpg");
    }

    .decaleLiens {
        margin-left: 20px;
        color: gray;
    }

    .decaleLiens a {
        color: gray;
    }

    .decaleLiens a:hover {
        color: #4B4B4B;
        cursor: pointer;
    }

</style>
