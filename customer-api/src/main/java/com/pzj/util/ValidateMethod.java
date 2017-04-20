package com.pzj.util;

public enum ValidateMethod {
    Null {
        @Override
        public void validate(Long defaultValue, boolean allowNull, String nullMessage) {
            // TODO Auto-generated method stub
            
        }
    },
    
    DefatulAndNull {
        @Override
        public void validate(Long defaultValue, boolean allowNull, String nullMessage) {
            // TODO Auto-generated method stub
            
        }
    },
    
    Empty {
        @Override
        public void validate(Long defaultValue, boolean allowNull, String nullMessage) {
            // TODO Auto-generated method stub
            
        }
    };
    
    
    public abstract void validate(Long defaultValue, boolean allowNull, String nullMessage);
}
