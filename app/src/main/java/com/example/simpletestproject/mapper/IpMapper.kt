package com.example.simpletestproject.mapper

import com.example.simpletestproject.dto.IpDto
import com.example.simpletestproject.entity.IP

class IpMapper {
    fun mapIpDtoToIP(ipDto: IpDto): IP{
        return IP(ip = ipDto.ip)
    }
}