package javaStudy;


    class Key {

        public void lookIntoAMirror(String name){
            System.out.println(name+"이(가) 거울을 본다.");
        }
        public void open(String name){
            System.out.println(name+"이(가) 화장실 문을 연다.");
        }
        public void close(String name){
            System.out.println(name+"이(가) 화장실 문을 닫는다.");
        }
        public void defecate(String name){
            System.out.println(name+"이(가) 싼다.");
        }
        public synchronized void useToilet(String name){
            lookIntoAMirror(name);
            open(name);
            defecate(name);
            close(name);
        }

    }

    class syc extends Thread{
        private String name;
        private Key key;
        public syc(String name,Key key){
            this.name=name;
            this.key=key;
        }
        public void run(){
            key.useToilet(name);
        }
    }
