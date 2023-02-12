package com.bl.pb.entity

class Result<T extends Map<String, Object>> {

    private enum Code {
        NO_PERMISSION('400'),
        OK('200'),
        INTERNAL_SERVER_ERR('500')
        String code

        Code(def code) {
            this.code = code
        }

        String getCode() {
            this.code
        }
    }

    String code
    String msg
    T data

    static Result ok(msg) {
        new Result(code: Code.OK.getCode(), msg: msg)
    }

    static Result fail(msg) {
        new Result(code: Code.INTERNAL_SERVER_ERR.getCode(), msg: msg)
    }

    Result addData(String k, Object v) {
        if (this.data == null) {
            this.data = new LinkedHashMap<String, Object>()

        }
        this.data.put(k,v)
        return this
    }

}
