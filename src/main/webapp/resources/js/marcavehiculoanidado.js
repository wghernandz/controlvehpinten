//import VueResource from '';
//Vue.use(VueResource);


var app= new Vue({
	el:'#app',
	data:{ 
		marcaSeleccionada:'Seleccione marca',
		modelos:[],
		selected:'',
		mode:'single',
		selectedDate:null,
	},
	
	methods:{
		mounted(){
						
			 this.ajaxRequest = true;
		        this.$http.post("modelosxmarca/"+this.marcaSeleccionada, 
		        		function (data, status, request) {
		                this.postResults = data;
		                this.ajaxRequest = false;
		            })
		            .then(response=>response.json())
		            .then((data)=>{
		            	//console.log(data)
		            	this.modelos=data;
		            })
		}
	}
	
})
