/*// 获取所有audios
var audios = document.getElementsByTagName("audio");
// 暂停函数
function pauseAll() {
    var self = this;
    [].forEach.call(audios, function (i) {
        // 将audios中其他的audio全部暂停
        i !== self && i.pause();
    })
}
// 给play事件绑定暂停函数
[].forEach.call(audios, function (i) {
    i.addEventListener("play", pauseAll.bind(i));
})*/

/*var audio = document.getElementsByTagName("audio");
			
				if(audio!==null){			
					//检测播放是否已暂停.audio.paused 在播放器播放时返回false.<span style="font-family: Arial, Helvetica, sans-serif;">在播放器暂停时返回true</span>
					if(!audio.paused)
					{				
						audio.pause();// 这个就是暂停//audio.play();// 这个就是播放
					}
				}
*/


	
		
	