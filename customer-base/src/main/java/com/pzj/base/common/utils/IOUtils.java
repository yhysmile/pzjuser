/**    
 * 文件名：IOUtils.java    
 *    
 * 版本信息：    
 * 日期：2014-7-7    
 * Copyright 足下 Corporation 2014     
 * 版权所有    
 *    
 */
package com.pzj.base.common.utils;

import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

/**
 * 
 * 项目名称：service.base.jar 类名称：IOUtils 类描述： 创建人：石月 创建时间：2014-7-7 下午4:43:36
 * 修改人：wushu 修改时间：2014-7-7 下午4:43:36 修改备注：
 * 
 * @version
 * 
 */
public class IOUtils {

    /**
     * 文件转流
     */
    public static InputStream upload(File file) {
        InputStream inputStream;
        try {
            inputStream = new FileInputStream(file);
            return inputStream;
        } catch (Exception e) {
            throw new ExceptionInInitializerError("文件转换为流失败,原因是:" + e.getLocalizedMessage());
        }
    }

    /**
     * 输出流转字节数组
     */
    public static byte[] InputStreamToByte(InputStream is) throws IOException {
        ByteArrayOutputStream bytestream = new ByteArrayOutputStream();
        int ch;
        while ((ch = is.read()) != -1) {
            bytestream.write(ch);
        }
        byte imgdata[] = bytestream.toByteArray();
        bytestream.close();
        return imgdata;
    }

    /**
     * 字节数据转输入流
     */
    public static InputStream ByteToInputStream(byte[] b) throws IOException {
        InputStream is = new ByteArrayInputStream(b);
        return is;
    }

    /**
     * 返回MAP,包含上传文件的类型及文件内容输入流
     */
    /*
    public static Map<String, Object> getFileMap(MultipartFile multipartFile) throws IOException {
     Map<String, Object> map = new HashMap<String, Object>();
     map.put("file", IOUtils.InputStreamToByte(multipartFile.getInputStream()));
     map.put("extension", getFileExtension(multipartFile.getOriginalFilename()));
     return map;
    }*/

    /**
     * 获取文件扩展名
     * 
     * @param file
     * @return
     */
    public static String getFileExtension(String fileName) {
        if (fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0) {
            return fileName.substring(fileName.lastIndexOf(".") + 1);
        } else {
            return "";
        }
    }

    /**
     * 字符数组转图片流
     */
    public static BufferedImage byteToBufferedImage(byte[] is) {
        BufferedImage image = null;
        try {
            ByteArrayInputStream in = new ByteArrayInputStream(is);
            image = ImageIO.read(in);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return image;
    }

    /**
     * 获得指定文件的byte数组
     */
    public static byte[] getBytes(String filePath) {
        byte[] buffer = null;
        try {
            File file = new File(filePath);
            FileInputStream fis = new FileInputStream(file);
            ByteArrayOutputStream bos = new ByteArrayOutputStream(1000);
            byte[] b = new byte[1000];
            int n;
            while ((n = fis.read(b)) != -1) {
                bos.write(b, 0, n);
            }
            fis.close();
            bos.close();
            buffer = bos.toByteArray();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return buffer;
    }

    /**
     * 根据byte数组，生成文件
     */
    public static String getFile(byte[] bfile, String filePath, String fileName) {
        BufferedOutputStream bos = null;
        FileOutputStream fos = null;
        File file = null;
        String path = null;
        try {
            File dir = new File(filePath);
            if (!dir.exists()) {// 判断文件目录是否存在 &&dir.isDirectory()
                dir.mkdirs();
            }
            file = new File(filePath + "\\" + fileName);
            fos = new FileOutputStream(file);
            bos = new BufferedOutputStream(fos);
            bos.write(bfile);
            path = file.getPath();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
        return path;
    }

    /**
     * 删除空目录
     * 
     * @param dir
     *            将要删除的目录路径
     */
    public static boolean doDeleteEmptyDir(String dir) {
        return (new File(dir)).delete();

    }

    /**
     * 递归删除目录下的所有文件及子目录下所有文件
     * 
     * @param dir
     *            将要删除的文件目录
     */
    public static boolean deleteDir(File dir) {
        if (dir.isDirectory()) {
            String[] children = dir.list();
            // 递归删除目录中的子目录下
            for (int i = 0; i < children.length; i++) {
                boolean success = deleteDir(new File(dir, children[i]));
                if (!success) {
                    return false;
                }
            }
        }
        return dir.delete();
    }

}
